package cn.jtools.db;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库CURD操作类
 * @author smartclover
 *
 */
public class DBOperator {
	
	private static String url = null;
	private static String username = null;
	private static String pwd = null;
	
	//类初始化的时候回加载static代码块
	static {
		url = "";
		username = "";
		pwd = "";
		
		try {
			Class.forName("");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接对象
	 * @return java.sql.Connection 对象或者null（异常）
	 */
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 关闭 ResultSet， Statement， Connection 对象 所持有的资源
	 * @param rst 
	 * 			 	需要关闭的结果集操作装置
	 * @param st
	 * 				需要关闭的指令操作装置
	 * @param con
	 * 				需要关闭的数据库连接
	 */
	public static void closeJDBC(ResultSet rst, Statement st, Connection con){
		
		if(rst != null){
			try {
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
				rst = null;
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
				st = null;
			}
		}
		
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				con = null;
			}
		}
	}
	
	/**
	 * 从数据库中查询数据返回一个集合
	 * @param cl 
	 * 				指定的实体类 类文件
	 * @param sql
	 * 				指定 查询语句
	 * @param args
	 * 				sql的参数（可选）<br>
	 * @return 封装有相关查询结果的list
	 * @实例 String sql = "select * from User where id=? and name=?"; <br>
	 *     exe_Query(User.class, sql, id, name); <br>
	 *     exe_Query(User.class, sql)
	 */
	public static List exe_Query(Class cl, String sql, Object...args ){
		
		//获取数据库连接
		Connection con = getConnection();
		if (con == null) {
			return null;
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//获取指令操作装置
			ps = con.prepareStatement(sql);
			
			//如果有代位符"?"则进行赋值操作
			for(int i = 0; i < args.length; i++){
				ps.setObject(i + 1, args[i]);
			}
			
			//执行操作获取结果集
			rs = ps.executeQuery();
			
			Method[] mtds = cl.getMethods();
			
			Map<String, Method> mts = new HashMap<String, Method>();
			for(int i = 0; i < mtds.length; i++){
				String nm = mtds[i].getName();
				if(nm.indexOf("set") == 0){
					mts.put(nm.substring(3).toLowerCase(), mtds[i]);
				}
			}
			
			//获取到rs所操作的表的原始信息集合
			ResultSetMetaData rmd = rs.getMetaData();
			//表的字段（列）个数
			int columnCount = rmd.getColumnCount();
			System.out.println("columnCount:" + columnCount);
			List list = new ArrayList();
			
			while(rs.next()){
				Object entity = null;
				
				try {
					entity = cl.newInstance();
					
					for(int i = 0; i < columnCount; i++){
						
						String cn = rmd.getColumnName(i + 1).toLowerCase();
						
						Method mt = mts.get(cn);
						
						if (mt != null) {
							mt.invoke(entity, rs.getObject(i+1));
						}else{
							throw new Exception("未找到属性为"+cn+"的方法");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
				list.add(entity);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeJDBC(rs, ps, con);
		}
		
		return null;
	}
	
	/**
	 * 从数据库查询数据返回一个单一实体
	 * @param cl
	 * 				实体类
	 * @param sql
	 * 				指定查询语句，如select * from user where id = ?
	 * @param args
	 * 				有多少占位符"?"，就传几个参数
	 * @return
	 */
	public static Object exe_QueryOne(Class cl, String sql, Object...args){
		List list = exe_Query(cl, sql, args);
		return ((list != null && list.size() > 0)?list.get(0):null);
	}
	
	/**
	 * 数据更新（增删改查）方法
	 * @param sql
	 * 				指定的sql语句
	 * @param args
	 * 				为占位符"?"赋值
	 * @return 返回操作结果 true 或 false
	 */
	public static boolean exe_Update(String sql, Object...args){
		
		//获取连接对象，判断是否可用
		Connection con = getConnection();
		if (con == null) {
			return false;
		}
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			
			if (args != null && args.length > 0) {
				for(int i = 0; i < args.length; i++){
					ps.setObject(i + 1, args[i]);
				}
			}
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeJDBC(null, ps, con);
		}
		return false;
	}
}
