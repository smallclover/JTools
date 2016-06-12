package cn.jtools.util;

import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

/**
 * 字符串操作工具类
 * 
 * @author smartclover
 * 
 */
public class StringUtil {

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str 需要判断的字符串
	 * 
	 * @return true or false
	 */
	public static boolean isEmpty(String str) {
		return ((str == null) || (str.length() == 0));
	}

	/**
	 * 转换字符串的字符集
	 * 
	 * @param source 需要转换的字符串
	 * 
	 * @param srcCharsetName 字符串原字符集
	 * 
	 * @param newCharset 目标字符集
	 * 
	 * @return	String
	 */
	public static String convertString(String source, String srcCharsetName,
			String newCharset) {
		if (srcCharsetName.equals(newCharset)) {//如果原字符集与目标字符集相同则直接返回字符串
			return source;
		}
		try {
			return new String(source.getBytes(srcCharsetName), newCharset);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	/**
	 * 判断是否包含指定的字符串
	 * 
	 * @param Source 字符串
	 * 
	 * @param Item 指定的字符串
	 * 
	 * @param separator 分隔符
	 * 
	 * @return true or false
	 */
	public static boolean isContain(String Source, String Item,
			String separator) {
		boolean isReturn = false;
		StringTokenizer st = null;
		st = new StringTokenizer(Source, separator);
		while (st.hasMoreTokens()) {
			if (Item.equals(st.nextToken())) {
				isReturn = true;
				break;
			}
		}
		return isReturn;
	}
	
	/**
	 * 检查字符串是否全部是小写
	 * @param str 原字符串
	 * @return true or false
	 */
	public static boolean isAllLowerCase(String str){
		if(StringUtil.isEmpty(str)){
			return false;
		}
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (Character.isLowerCase(str.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 检查字符串是否全部为大写
	 * @param str 原字符串
	 * @return true or false
	 */
	public static boolean isAllUpperCase(String str){
		if(StringUtil.isEmpty(str)){
			return false;
		}
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (Character.isUpperCase(str.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 反转字符串
	 * @param str原字符串
	 * @return String
	 */
	public static String reverse(String str){
		if(str == null){
			return null;
		}
		return new StringBuilder().reverse().toString();
	}
}
