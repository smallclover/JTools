package cn.jtools.db;

import java.io.Serializable;

/**
 * 数据库连接参数
 * 
 * @author smartclover
 *
 */
public class ConnectionParam implements Serializable {

	/**
	 * 默认的序列化参数
	 */
	private static final long serialVersionUID = 1L;

	private String driver;// 数据库连接驱动
	private String url;// 数据库连接路径
	private String user;// 数据库连接用户
	private String password;// 数据库连接密码
	private String testTable;// 数据库测试表
	private int minConnection = 0;// 数据库连接池最小连接数
	private int maxConnection = 50;// 数据库连接池最大连接数
	private long timeout = 600000;// 连接的最大空闲时间
	private long waitTime = 30000;// 取得连接的最大等待时间
	private int increamtalConnections = 5;// 连接池自动增加的连接数量
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTestTable() {
		return testTable;
	}

	public void setTestTable(String testTable) {
		this.testTable = testTable;
	}
	
	public int getMinConnection() {
		return minConnection;
	}

	public void setMinConnection(int minConnection) {
		this.minConnection = minConnection;
	}

	public int getMaxConnection() {
		return maxConnection;
	}

	public void setMaxConnection(int maxConnection) {
		this.maxConnection = maxConnection;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}

	public int getIncreamtalConnections() {
		return increamtalConnections;
	}

	public void setIncreamtalConnections(int increamtalConnections) {
		this.increamtalConnections = increamtalConnections;
	}
}
