package cn.jtools.base.datastruct;

/**
 * 
 * @author smallclover
 *
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {
	private Object[] objs = new Object[16];
	private int size = 0;

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for(int i = 0; i < size; i++){
			objs[size] = null;
		}
		size = 0;
	}

	@Override
	public int length() {
		return size;
	}

	@Override
	public boolean push(T data) {
		if(size >= objs.length){
			resize();
		}
		
		objs[size++] = data; 
		return true;
	}

	@Override
	public T pop() {
		if(size == 0){
			return null;
		}
		T t = (T) objs[--size];
		objs[size] = null;
		return t;
	}
	
	
	private void resize(){
		Object[] temp = new Object[objs.length * 3 /2 + 1];
		for(int i = 0; i < size; i++){
			temp[i] = objs[i];
			objs[i] = null;
		}
		objs = temp;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ArrayStack:[");
		for(int i = 0; i < size; i++){
			sb.append(objs[i].toString());
			if(i != size - 1){
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ArrayStack<Integer> as = new ArrayStack<>();
		as.push(10);
		as.push(11);
		as.push(12);
		as.pop();
		System.out.println(as);
	}
}
