package cn.jtools.util;

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
 * ���ݿ�CURD������
 * @author smartclover
 *
 */
public class DBOperator {
	
	private static String url = null;
	private static String username = null;
	private static String pwd = null;
	
	//���ʼ����ʱ��ؼ���static�����
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
	 * ��ȡ���ݿ����Ӷ���
	 * @return java.sql.Connection �������null���쳣��
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
	 * �ر� ResultSet�� Statement�� Connection ���� �����е���Դ
	 * @param rst 
	 * 			 	��Ҫ�رյĽ��������װ��
	 * @param st
	 * 				��Ҫ�رյ�ָ�����װ��
	 * @param con
	 * 				��Ҫ�رյ����ݿ�����
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
	 * �����ݿ��в�ѯ����
	 * @param cl 
	 * 				ָ����ʵ���� ���ļ�
	 * @param sql
	 * 				ָ�� ��ѯ���
	 * @param args
	 * 				sql�Ĳ�������ѡ��<br>
	 * @return ��װ����ز�ѯ�����list
	 * @ʵ�� String sql = "select * from User where id=? and name=?"; <br>
	 *     exe_Query(User.class, sql, id, name); <br>
	 *     exe_Query(User.class, sql)
	 */
	public static List exe_Query(Class cl, String sql, Object...args ){
		
		//��ȡ���ݿ�����
		Connection con = getConnection();
		if (con == null) {
			return null;
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//��ȡָ�����װ��
			ps = con.prepareStatement(sql);
			
			//����д�λ��"?"����и�ֵ����
			for(int i = 0; i < args.length; i++){
				ps.setObject(i + 1, args[i]);
			}
			
			//ִ�в�����ȡ�����
			rs = ps.executeQuery();
			
			Method[] mtds = cl.getMethods();
			
			Map<String, Method> mts = new HashMap<String, Method>();
			for(int i = 0; i < mtds.length; i++){
				String nm = mtds[i].getName();
				if(nm.indexOf("set") == 0){
					mts.put(nm.substring(3).toLowerCase(), mtds[i]);
				}
			}
			
			//��ȡ��rs�������ı��ԭʼ��Ϣ����
			ResultSetMetaData rmd = rs.getMetaData();
			//����ֶΣ��У�����
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
							throw new Exception("δ�ҵ�����Ϊ"+cn+"�ķ���");
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
	
}
