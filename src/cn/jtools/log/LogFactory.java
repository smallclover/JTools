package cn.jtools.log;

import cn.jtools.log.impl.JDKLoggerFactory;

/**
 * Logger对象工厂
 * @author smallclover
 *
 */
public final class LogFactory {
	private static  ILogFactoryInterface iLogFactory = new JDKLoggerFactory();
	
	
	public static void setLoggerFactory(ILogFactoryInterface iLogFactoryInterface){
		iLogFactory = iLogFactoryInterface;
	}
	
	public static ILogger getLogger(Class clazz){
		return getLogger(clazz.getName());
	}
	
	public static ILogger getLogger(String name){
		return iLogFactory.getLogger(name);
	}
}
