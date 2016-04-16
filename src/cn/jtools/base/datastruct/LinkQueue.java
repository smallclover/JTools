package cn.jtools.base.datastruct;

/**
 * 链队列
 * 
 * 队首删除，队尾增加
 * @author smallclover
 *
 * @param <T>
 */
public class LinkQueue<T> {
	
	private class Node{
		public T data;//存储数据
		
		public Node next;//存储下一个节点
		
		public Node(){
			
		}
		
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
		
	}
	
	
	private Node head;//头节点指针
	
	private Node tail;//尾节点指针
	
	private int size = 0;//节点数量
	
	/**
	 * 初始化一个队列
	 */
	public LinkQueue(){
		Node n = new Node(null,null);
		n.next = null;
		head = tail = n;
	}
	
	/**
	 * 入队列
	 * @param data
	 */
	public void enQueue(T data){
		Node s = new Node(data,null);
		tail.next = s;
		tail = s;
		size++;
	}
	
	/**
	 * 出队列
	 * @return 返回被移除的节点所保存的数据
	 */
	public T deQueue(){
		if(tail == head){
			try {
				throw new Exception("队列为空");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}else{
			
			Node p = head.next;
			T x = p.data;
			head.next = p.next;
			if(p.next == null){
				tail = head;
			}
			p = null;
			size--;
			return x;
		}
	}
	
	/**
	 * 队列大小
	 * @return
	 */
	public int size(){
		return size;
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * 打印整个队列
	 */
	public String toString(){
		if(isEmpty()){
			return"[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			for(Node current = head.next;current!= null;current = current.next){
				sb.append(current.data.toString()+", ");
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
//			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
        LinkQueue<Integer> queue=new LinkQueue<Integer>();  
        queue.enQueue(1);  
        queue.enQueue(2);  
        queue.enQueue(3);  
        queue.enQueue(4);  
        queue.enQueue(5);  
        queue.enQueue(6);  
        System.out.println(queue);  
        System.out.println("出队："+queue.deQueue());  
        System.out.println("队列长度="+queue.size());  
        System.out.println(queue);  
        System.out.println("出队："+queue.deQueue());  
        System.out.println("队列长度="+queue.size());  
        System.out.println(queue);  
        System.out.println("出队："+queue.deQueue());  
        System.out.println("队列长度="+queue.size());  
        System.out.println(queue);
	}
}