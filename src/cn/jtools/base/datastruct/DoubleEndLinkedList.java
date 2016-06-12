package cn.jtools.base.datastruct;

/**
 * 双端链表
 * 
 * @author smartclover
 * 
 */
public class DoubleEndLinkedList implements List{

	/**
	 * 
	 * 链表存储的节点类型
	 * 
	 */
	private class Data {
		private Object obj;// 存储数据
		private Data next = null;// 指向下一个链表节点

		Data(Object obj) {
			this.obj = obj;
		}
	}

	private Data first = null;// 头结点
	private Data last = null;// 尾结点

	/**
	 * 从头结点插入
	 * 
	 * @param obj
	 */
	public void insertFirst(Object obj) {
		Data data = new Data(obj);
		// 如果头结点为空，说明链表为空,头结点和尾节点都指向同一个结点。
		if (first == null) {
			last = data;
		}
		data.next = first;// 原先的first结点设置为新添加的data的next结点
		first = data;// 将新添加的data设置为first结点
	}

	/**
	 * 从尾节点插入
	 * 
	 * @param obj
	 */
	public void insertLast(Object obj) {
		Data data = new Data(obj);
		if (first == null) {
			first = data;
		} else {
			last.next = data;// 将数据添加到尾部
			// System.out.println(last.next);
		}
		last = data;// 将last指向新添加的数据
		// System.out.println(last);
	}

	/**
	 * 删除头结点
	 * 
	 * @return 返回该头结点的数值
	 * @throws Exception
	 */
	public Object deleteFirst() throws Exception {
		if (first == null) {
			throw new Exception("empty");
		}
		Data temp = first;
		if (first.next == null) {
			last = null;
		}
		first = first.next;
		return temp.obj;
	}

	/**
	 * 删除尾结点
	 * 
	 * @throws Exception
	 */
	public void deleteLast() throws Exception {
		if (first == null) {
			throw new Exception("empty");
		}

		if (first.next == null) {
			first = null;
			last = null;
		} else {
			Data temp = first;
			while (temp.next != null) {
				if (temp.next == last) {
					last = temp;
					last.next = null;
				}
				temp = temp.next;
			}
		}

	}

	/**
	 * 查找指定的结点
	 * 
	 * @param obj
	 * @return 指定的对象结点
	 * @throws Exception
	 */
	public Object find(Object obj) throws Exception {
		if (first == null) {
			throw new Exception("empty");
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

	/*
	 * public boolean isEmpty() { return (first == null); }
	 */

	/**
	 * 打印所有结点
	 */
	public void dispaly() {
		if (first == null) {
			System.out.println("empty");
		}
		Data cur = first;
		while (cur != null) {
			System.out.print(cur.obj.toString() + "->");
			cur = cur.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		DoubleEndLinkedList dell = new DoubleEndLinkedList();
		dell.insertFirst(2);
		dell.insertFirst(1);
		dell.insertLast(3);
		dell.dispaly();
	}
}
