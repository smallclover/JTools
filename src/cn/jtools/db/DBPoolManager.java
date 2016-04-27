package cn.jtools.db;

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
