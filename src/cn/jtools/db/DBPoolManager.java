package cn.jtools.db;

/**
 * 数据库连接池生命周期管理
 * 
 * 单例模式
 * @author smallclover
 *
 */
public class DBPoolManager {
	public static volatile DBPoolManager dbpm;
	
	private DBPoolManager(){}
	
	//双重监测机制
	public static DBPoolManager getDBPoolManager(){
		if(dbpm == null){
			synchronized (DBPoolManager.class) {
				if(dbpm == null){
					dbpm = new DBPoolManager();
				}
			}
		}
		return dbpm;
	}
}
