package cn.jtools.log;

/**
 * 适配各种日志实现
 * @author smallclover
 *
 */
public interface ILogFactoryInterface {
	
	/**
	 * 根据给予的名字返回自定义的日志对象
	 * @param name
	 * @return
	 */
	ILogger getLogger(String name);
}
