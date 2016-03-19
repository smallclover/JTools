package cn.jtools.util;

/**
 * 类操作工具类
 * @author smartclover
 *
 */
public class ClassUtil {
	
	/**
	 * 获取类加载器
	 * @return
	 */
	public static ClassLoader getClassLoader(){
		return Thread.currentThread().getContextClassLoader();//?
	}
}
