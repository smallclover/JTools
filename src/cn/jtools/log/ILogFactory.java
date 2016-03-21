package cn.jtools.log;

public interface ILogFactory {
	Log getLog(Class<?> clazz);
	Log getLog(String name);
}
