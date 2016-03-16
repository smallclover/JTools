package cn.jtools.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Vector;
/**
 * 数据库连接池
 * @author smartclover
 *
 */
public class DBConnectionPool {
	
	private ConnectionParam param;
	private String testTable = "";//测试连接是否可用，值为测试表名，默认是空
	private Vector connections = null;//存放数据库连接，初始为空，存放PooledConnection类型
	
	public ConnectionParam getParam() {
		return param;
	}
	public void setParam(ConnectionParam param) {
		this.param = param;
	}
	
	/**
	 * 含参构造函数
	 * @param param
	 */
	public DBConnectionPool(ConnectionParam param) {
		this.param = param;
	}
	
	/**
	 * 默认构造函数
	 */
	public DBConnectionPool(){
		//
	}
	
	/**
	 * 获取测试表名
	 * @return 返回测试表名
	 */
	public String getTestTable() {
		return testTable;
	}
	
	/**
	 * 设置测试表名
	 * @param testTable 测试表名
	 */
	public void setTestTable(String testTable) {
		this.testTable = testTable;
	}
	
	
	public synchronized void createPool() throws Exception{
		if(connections != null){
			System.out.println("数据库连接池已经被创建！");
			return;
		}
		
		Driver driver = (Driver) (Class.forName(param.getDriver()).newInstance()); 
		DriverManager.registerDriver(driver);
		connections = new Vector();
		
		createConnections(param.getMinConnection());
		System.out.println("数据库连接池创建成功！");
	}
	
	private void createConnections(int numConnections) throws SQLException{
		
		for(int x = 0; x < numConnections; x++){
			if(param.getMaxConnection() > 0 && connections.size() >= param.getMaxConnection()){
				break;
			}
			
			try {
				connections.addElement(new PooledConnection(newConnection()));
			} catch (SQLException e) {
				System.out.println("创建数据库连接失败！"+ e.getMessage());
				throw new SQLException();
			}
			System.out.println("已经建立" + x + "了数据库连接");
		}
	}
	
	private Connection newConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(param.getUrl(), param.getUser(), param.getPassword());
		
		if(connections.size() == 0){
			DatabaseMetaData metaData = conn.getMetaData();
			int driverMaxConnections = metaData.getMaxConnections();
			
			if(driverMaxConnections > 0 && param.getMaxConnection() > driverMaxConnections){
				param.setMaxConnection(driverMaxConnections);
			}
		}
		return conn;
	}
	
	
	public synchronized Connection getConnection() throws SQLException{
		if(connections == null){
			return null;
		}
		
		Connection conn = getFreeConnection();
		while(conn == null){
			wait(250);
			conn = getFreeConnection();
		}
		
		return conn;
	}
	
	
	private Connection getFreeConnection() throws SQLException{
		
		Connection conn = findFreeConnection();
		
		if(conn == null){
			createConnections(param.getIncreamtalConnections());
			conn = findFreeConnection();
			if(conn == null){
				return null;
			}
		}
		return conn;
	}
	
	private Connection findFreeConnection(){
		
		Connection conn = null;
		PooledConnection pConn = null;
		
		Enumeration enumerate = connections.elements();//?
		while(enumerate.hasMoreElements()){
			pConn = (PooledConnection) enumerate.nextElement();
			if(!pConn.isBusy()){
				conn = pConn.getConnection();
				pConn.setBusy(true);
				if(!testConnection(conn)){
					try {
						conn = newConnection();
					} catch (SQLException e) {
						 System.out.println(" 创建数据库连接失败！ " + e.getMessage());
						 return null;
					}
					
					pConn.setConnection(conn);
				}
				break;
			}
		}
		return conn;
	}
	
	private boolean testConnection(Connection conn){
		
			try {
				if("".equals(testTable)){//这里是用testTable判断空还是用空判断testTable，testTable的话可能会存在nullPointer的问题
					conn.setAutoCommit(true);
				}else{
					Statement stmt = conn.createStatement();
					stmt.execute("select * from " + testTable);
				}
			} catch (SQLException e) {
				closeConnecion(conn);
				return false;
			}
			return true;
	}
	
	public void returnConnection(Connection conn){
		if(connections == null){
			System.out.println("连接池不存在，无法返回此连接到连接池中！");
			return;
		}
		
		PooledConnection pConn = null;
		Enumeration enumerate = connections.elements();
		
		while(enumerate.hasMoreElements()){
			pConn = (PooledConnection) enumerate.nextElement();
			
			if(conn == pConn.getConnection()){
				pConn.setBusy(false);
				break;
			}
		}
	}
	
	public synchronized void refreshConnections() throws SQLException{
		if(connections == null){
			System.out.println("连接池不存在！");
			return;
		}
		
		PooledConnection pConn = null;
		Enumeration enumerate = connections.elements();
		while(enumerate.hasMoreElements()){
			pConn = (PooledConnection) enumerate.nextElement();
			if(pConn.isBusy()){
				wait(5*1000);
			}
			closeConnecion(pConn.getConnection());
			pConn.setConnection(newConnection());
			pConn.setBusy(false);
		}
	}
	
	public synchronized void closeConnectionPool(){//?
		if(connections == null){
			System.out.println("连接池不存在！无法关闭");
			return;
		}
		
		PooledConnection pConn = null;
		Enumeration enumerate = connections.elements();
		while(enumerate.hasMoreElements()){
			pConn = (PooledConnection) enumerate.nextElement();
			if(pConn.isBusy()){
				wait(5*1000);
			}
			closeConnecion(pConn.getConnection());
			connections.removeElement(pConn);
		}
		
		connections = null;
	}
	
	private void closeConnecion(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("关闭数据库连接出错：" + e.getMessage());
		}
	}
	
	private void wait(int mSeconds){
		try {
			Thread.sleep(mSeconds);
		} catch (InterruptedException e) {
			//
		}
	}
	
	class PooledConnection{
		Connection connection = null;//?
		boolean busy = false;//?private 
		
		public PooledConnection() {
			
		}
		
		public PooledConnection(Connection connection){
			this.connection = connection;
		}
		
		public Connection getConnection() {
			return connection;
		}

		public void setConnection(Connection connection) {
			this.connection = connection;
		}

		public boolean isBusy() {
			return busy;
		}

		public void setBusy(boolean busy) {
			this.busy = busy;
		}

	}
}
