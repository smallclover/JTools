package cn.jtools.log;

/**
 * 
 * @author smartclover 日志工厂
 */
public interface ILogFactory {
	Log getLog(Class<?> clazz);// 根据Class类生产Log对象

	Log getLog(String name);// 根据类名获得Log对象
}
