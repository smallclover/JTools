package cn.jtools.log;

/**
 * 四种日志记录等级顺序由低到高 1. DEBUG 2. INFO 3. WARN 4. ERROR
 * 
 * @author smartclover
 * 
 */
public abstract class Log {
	private static ILogFactory defaultLogFactory = null;

	/**
	 * 类初始化的时候调用该静态代码块，有且只执行一次init函数
	 */
	static {
		init();
	}

	static void init() {
		if (defaultLogFactory == null) {
			try {
				Class.forName("org.apache.log4j.Logger");// 如果默认的日志工厂对象为空，尝试加载log4j写出器
				Class<?> log4jLogFactoryClass = Class
						.forName("cn.jTools.log.Log4jLogFactory");// 如果默认的日志工厂对象为空，尝试加载log4j工厂
				defaultLogFactory = (ILogFactory) log4jLogFactoryClass
						.newInstance();// 获取log4j工厂实例
			} catch (Exception e) {
				defaultLogFactory = new JdkLogFactory();// 发生异常调用JDKlog工厂
			}
		}
	}

	/**
	 * 设置默认的日志工厂
	 * 
	 * @param defaultFactory
	 */
	static void setDefaultLogFactory(ILogFactory defaultFactory) {
		if (defaultFactory == null) {
			throw new IllegalArgumentException(
					"defaultLogFactory can not be null.");
		}
		Log.defaultLogFactory = defaultFactory;
	}

	public static Log getLog(Class<?> clazz) {
		return defaultLogFactory.getLog(clazz);
	}

	public static Log getLog(String name) {
		return defaultLogFactory.getLog(name);
	}

	/**
	 * 4种日志等级
	 * 
	 * @param message
	 */
	public abstract void debug(String message);

	public abstract void debug(String message, Throwable t);

	public abstract void info(String message);

	public abstract void info(String message, Throwable t);

	public abstract void warn(String message);

	public abstract void warn(String message, Throwable t);

	public abstract void error(String message);

	public abstract void error(String message, Throwable t);

	// fatal 致命的
	/*
	 * public abstract void fatal(String message);
	 * 
	 * public abstract void fatal(String message, Throwable t);
	 */

	/**
	 * 设置日志等级是否可用
	 * 
	 * @return
	 */
	public abstract boolean isDebugEnabled();

	public abstract boolean isInfoEnabled();

	public abstract boolean isWarnEnabled();

	public abstract boolean isErrorEnabled();

	// public abstract boolean isFatalEnabled();
}
