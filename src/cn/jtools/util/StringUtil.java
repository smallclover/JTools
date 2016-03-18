package cn.jtools.util;

import java.io.UnsupportedEncodingException;

/**
 * 字符串操作工具类
 * @author smartclover
 *
 */
public class StringUtil {
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return ((str == null) || (str.length() == 0));
	}
	
	/**
	 * Converts string charset. If charset names are the same, the same string is returned.
	 * 转换字符串编码格式，如果编码格式相同，则直接返回这个字符串。
	 * @return
	 */
	public static String convertString(String source, String srcCharsetName, String newCharset){//convert转换
		if(srcCharsetName.equals(newCharset)){
			return source;
		}
		try {
			return new String(source.getBytes(srcCharsetName), newCharset);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
