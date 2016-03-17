package cn.jtools.db;

import java.io.Serializable;
/**
 * 数据库连接参数
 * @author smartclover
 *
 */
public class ConnectionParam implements Serializable {

	/**
	 * 默认的序列化参数
	 */
	private static final long serialVersionUID = 1L;
	
	private String driver;//数据库连接驱动
	private String url;//数据库连接路径
	private String user;//数据库连接用户
	private String password;//数据库连接密码
	private int minConnection;//数据库连接池最小连接数
	private int maxConnection;//数据库连接池最大连接数
	private long timeoutValue;//连接的最大空闲时间
	private long waitTime;//取得连接的最大等待时间
	private int increamtalConnections = 5;//连接池自动增加的连接数量
	
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
	public long getTimeoutValue() {
		return timeoutValue;
	}
	public void setTimeoutValue(long timeoutValue) {
		this.timeoutValue = timeoutValue;
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