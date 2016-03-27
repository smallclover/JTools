package cn.jtools.algorithm;

/**
 * 单链表Singly LinkedList
 * 
 * @author smartclover
 * 
 */
public class LinkedList {
	// 链表节点
	private class Data {
		private Object obj; // 存储的数据
		private Data next = null; // 指向下一个节点的指针

		public Data(Object obj) {
			this.obj = obj;
		}
	}

	private Data first = null; // 链表的头指针

	/**
	 * 从头结点插入新的节点
	 * 
	 * @param obj
	 */
	public void insertFirst(Object obj) {
		Data data = new Data(obj);
		data.next = first;
		System.out.println();
		first = data;
	}

	/**
	 * 删除头结点
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object deleteFirst() throws Exception {
		if (first == null) {
			throw new Exception("LinkedList is empty!");
		}

		Data temp = first;
		first = first.next;
		return temp.obj;
	}

	/**
	 * 查找节点
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object find(Object obj) throws Exception {
		if (first == null) {
			throw new Exception("LinkedList is empty!");
		}
		Data cur = first;
		while (cur != null) {
			if (cur.obj.equals(obj)) {
				return cur.obj;
			}
			cur = cur.next;
		}
		return null;
	}

	/**
	 * 移除节点
	 * 
	 * @param obj
	 * @throws Exception
	 */
	public void remove(Object obj) throws Exception {
		if (first == null) {
			throw new Exception("LinkedList is empty!");
		}
		if (first.obj.equals(obj)) {
			first = first.next;
		} else {
			Data pre = first;// previous(前一个)
			Data cur = first.next;// current(当前)
			while (cur != null) {
				if (cur.obj.equals(obj)) {
					pre.next = cur.next;
				}
				pre = cur;
				cur = cur.next;
			}
		}
	}

	/**
	 * 判断是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (first == null);
	}

	/**
	 * 打印链表
	 */
	public void display() {
		if (first == null) {
			System.out.println("empty");
		}
		Data cur = first;
		while (cur != null) {
			System.out.print(cur.obj.toString() + " -> ");
			cur = cur.next;
		}
		System.out.println();
	}

	// 测试
	public static void main(String[] args) throws Exception {
		LinkedList ll = new LinkedList();
		ll.insertFirst(4);
		ll.insertFirst(3);
		ll.insertFirst(2);
		ll.insertFirst(1);
		ll.display();
		ll.deleteFirst();
		ll.display();
		ll.remove(3);
		ll.display();
		System.out.println(ll.find(1));
		System.out.println(ll.find(4));
	}
}