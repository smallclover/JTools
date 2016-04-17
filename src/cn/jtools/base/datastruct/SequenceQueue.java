package cn.jtools.base.datastruct;

import javax.sound.midi.Sequence;

public class SequenceQueue<E>{

	E[] a;
	private static final int DEFAULT_SIZE = 10;
	
	int head;
	
	int tail;
	
	public SequenceQueue(){
		this(DEFAULT_SIZE);
	}
	
	public SequenceQueue(int size){
		a = (E[]) new Object[size];
		head = 0;
		tail = 0;
	}
	
	public boolean enQuene(E obj){
		if((tail + 1) % a.length == head){
			return false;
		}else{
			a[tail] = obj;
			tail = (tail + 1)%a.length;
			return true;
		}
	}
	
	public E deQueue(){
		if(tail == head){
			return null;
		}else{
			E obj = a[head];
			head = (head + 1)%a.length;
			return obj;
		}
	}
	
	public int size(){
		return (tail - head)&(a.length - 1);
	}
	
	public int length(){
		if(tail > head){
			return tail - head;
		}else{
			return a.length - 1;
		}
	}
	
	public boolean isEmpty(){
		return tail == head;
	}
	
	 public static void main(String[] args) {  
	        SequenceQueue<String> queue = new SequenceQueue<String>(4);  
	        queue.enQuene("1");
	        queue.enQuene("2");
	        queue.enQuene("3");
	        System.out.println("size="+queue.size());  
	        int size=queue.size();  
	        System.out.println("*******出栈操作*******");  
	        for(int i=0; i<size;i++){  
	            System.out.print(queue.deQueue()+" ");  
	        }  
	          
	    }  
}
