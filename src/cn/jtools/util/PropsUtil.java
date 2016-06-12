package cn.jtools.util;

import cn.jtools.exception.GenerateException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件操作类
 * 
 * @author smartclover
 *
 */
public class PropsUtil {

	/**
	 * 加载属性文件 
	 * @param propsPath 配置文件路径
	 * @return Properties object
	 */
	public static Properties loadProps(String propsPath) {
		Properties props = new Properties();
		InputStream is = null;
		try {
			if (StringUtil.isEmpty(propsPath)) {
				throw new IllegalAccessException();
			}
			String suffix = ".properties";
			if(propsPath.lastIndexOf(suffix) == -1){
				propsPath += suffix;
			}
			is = ClassUtil.getClassLoader().getResourceAsStream(propsPath);
			if(is != null){
				props.load(is);
			}
		} catch (Exception e) {
			throw new GenerateException("属性文件加载失败",e);
		} finally{
				try {
					if(is != null){
						is.close();
					}
				} catch (IOException e) {
					throw new GenerateException("释放资源失败",e);
				}
		}
		return props;
	}
	
	/**
	 * 获取字符型属性
	 * @param props 配置文件对象
	 * @param key 属性键
	 * @return 属性的值
	 */
	public static String getString(Properties props, String key){
		String value = "";
		if(props.containsKey(key)){
			value = props.getProperty(key);
		}
		return value;
	}
}
