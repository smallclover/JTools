package cn.jtools.base.datastruct;

public class LinkedStack<T> implements Stack<T>{
	
	private final class Node{
		private Node pre;
		private T data;
	}
	
	private Node top;
	
	private int size;
	
	public LinkedStack(){
		top = null;
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		top = null;
		size = 0;
	}

	@Override
	public int length() {
		return size;
	}

	@Override
	public boolean push(T data) {
		Node node = new Node();
		node.data = data;
		node.pre = top;
		top = node;
		size++;
		return true;
	}

	@Override
	public T pop() {
		if(top != null){
			Node node = top;
			top = top.pre;
			size--;
			return node.data;
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		LinkedStack<Integer> ls = new LinkedStack<>();
		ls.push(1);
		ls.push(2);
		ls.push(3);
		Integer result;
		StringBuilder sb = new StringBuilder();
		while((result = ls.pop()) != null){
			sb.append(result);
		}
		System.out.println(sb +"　");
	}
}
