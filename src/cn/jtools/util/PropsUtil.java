package cn.jtools.util;

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
	 * @param propsPath
	 * @return 属性文件的对象
	 */
	public static Properties loadProps(String propsPath) {//?属性文件需要位于src目录下？？
		Properties props = new Properties();
		InputStream is = null;
		try {
			if (StringUtil.isEmpty(propsPath)) {
				throw new IllegalAccessException();//?
			}
			String suffix = ".properties";
			if(propsPath.lastIndexOf(suffix) == -1){//?
				propsPath += suffix;
			}
			is = ClassUtil.getClassLoader().getResourceAsStream(propsPath);
			if(is != null){
				props.load(is);
			}
		} catch (Exception e) {
			System.out.println("属性文件加载失败");
			throw new RuntimeException(e);
		} finally{
				try {
					if(is != null){
						is.close();
					}
				} catch (IOException e) {
					System.out.println("释放资源出错");
				}
		}
		return props;
	}
	
	/**
	 * 获取字符型属性
	 * @param props
	 * @param key
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
