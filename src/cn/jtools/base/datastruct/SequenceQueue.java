package cn.jtools.base.datastruct;

/**
 * 顺序队列
 * @author smallclover
 *
 * @param <E>
 */
public class SequenceQueue<E>{

	E[] a;//对象数组， 队列最多存储a.length - 1个对象
	private static final int DEFAULT_SIZE = 10;//默认初始化大小
	
	int head;//队首下标
	
	int tail;//队尾下标
	
	public SequenceQueue(){
		this(DEFAULT_SIZE);
	}
	
	/**
	 * 初始化指定长度的队列
	 * @param size
	 */
	public SequenceQueue(int size){
		a = (E[]) new Object[size];
		head = 0;
		tail = 0;
	}
	
	/**
	 * 队尾入队
	 * @param obj
	 * @return 队列满的时候返回false，否则返回true
	 */
	public boolean enQuene(E obj){
		if((tail + 1) % a.length == head){
			return false;
		}else{
			a[tail] = obj;
			tail = (tail + 1)%a.length;
			return true;
		}
	}
	
	/**
	 * 队首出队
	 * @return
	 */
	public E deQueue(){
		if(tail == head){
			return null;
		}else{
			E obj = a[head];
			head = (head + 1)%a.length;
			return obj;
		}
	}
	
	/**
	 * 队列长度
	 * @return
	 */
	public int size(){
		return (tail - head)&(a.length - 1);
	}
	
	//?
	public int length(){
		if(tail > head){
			return tail - head;
		}else{
			return a.length - 1;
		}
	}
	
	/**
	 * 判断是否为空
	 * @return
	 */
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
