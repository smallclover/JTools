package cn.jtools.base.datastruct;

/**
 * 数据结构：栈
 * @param <T>
 */
public interface Stack<T> extends AbstractDataStruct{
	
	boolean isEmpty();
	
	void clear();
	
	int length();
	
	boolean push(T a);
	
	T pop();
}
