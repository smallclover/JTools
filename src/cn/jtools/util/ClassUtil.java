package cn.jtools.util;

/**
 * 类操作工具类
 * @author smartclover
 *
 */
public class ClassUtil {
	
	/**
	 * 获取当前线程类加载器
	 * @return 当前线程类加载器
	 */
	public static ClassLoader getClassLoader(){
		return Thread.currentThread().getContextClassLoader();
	}
}
