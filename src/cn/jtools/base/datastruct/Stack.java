package cn.jtools.base.datastruct;

public interface Stack<T> {
	
	boolean isEmpty();
	
	void clear();
	
	int length();
	
	boolean push(T a);
	
	T pop();
}
