package cn.jtools.log;

/**
 * 简单的日志接口
 * @author smallclover
 *
 */
public interface ILogger {
	
	/**
	 * 
	 * 日志对象等级
	 * 严重程度从底到高
	 *
	 */
	public enum ILevel {
		TRACE(1),
		DEBUG(2),
		INFO(3),
		WARN(4),
		ERROR(5);
		
		private final int value;
		
		ILevel(int value){
			this.value = value;
		}
		
		/**
		 * 如果默认的日志等级支持外部传递的日志等级，则返回真
		 * @param ILevel 日志等级
		 * @return true or false
		 */
		public boolean isEnabledFor(ILevel iLevel){
			return this.value >= iLevel.value;
		}
	}
	
	/**
	 * 返回日志对象的名字
	 * @return String
	 */
	public String getName();
	
	/**
	 * 如果支持该日志等级
	 * @param iLevel
	 * @return true or false
	 */
	public boolean isEnabled(ILevel iLevel);
	
	/**
	 * 根据日志级别提供日志信息
	 * @param iLevel
	 * @param message
	 */
	public void log(ILevel iLevel, String message);
	
	/**
	 * 如果支持 Trace日志等级
	 */
	public boolean isTraceEnabled();

	/**
	 * 打印Trace等级的日志
	 */
	public void trace(String message);

	// ---------------------------------------------------------------- debug

	/**
	 * 
	 */
	public boolean isDebugEnabled();

	/**
	 * 
	 */
	public void debug(String message);

	// ---------------------------------------------------------------- info
	/**
	 * 
	 */
	public boolean isInfoEnabled();

	/**
	 * 
	 */
	public void info(String message);

	// ---------------------------------------------------------------- warn

	/**
	 * 
	 */
	public boolean isWarnEnabled();

	/**
	 * 
	 */
	public void warn(String message);

	/**
	 * 
	 */
	public void warn(String message, Throwable throwable);

	// ---------------------------------------------------------------- error

	/**
	 * 
	 */
	public boolean isErrorEnabled();

	/**
	 * 
	 */
	public void error(String message);

	/**
	 * 
	 */
	public void error(String message, Throwable throwable);
}
