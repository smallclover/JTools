package cn.jtools.algorithm;

/**
 * 双端链表
 * 
 * @author smartclover
 * 
 */
public class DoubleEndLinkedList {

	private class Data {
		private Object obj;
		private Data next = null;

		Data(Object obj) {
			this.obj = obj;
		}
	}

	private Data first = null;
	private Data last = null;

	public void insertFirst(Object obj) {
		Data data = new Data(obj);
		if (first == null) {
			last = data;
		}
		data.next = first;
		first = data;
	}

	public void insertLast(Object obj) {
		Data data = new Data(obj);
		if (first == null) {
			first = data;
		} else {
			last.next = data;
		}
		last = data;
	}

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
}
