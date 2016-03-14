package cn.jtools.algorithm;

/**
 * 二叉搜索树
 * @author smartclover
 *
 */
public class BinaryTree {
	
	//节点类
	private class Node{
		private Node left;//指向做节点的引用
		private Node right;//指向有节点的引用
		private int value;//该结点存储的值
		
		public Node(Node left, Node right, int value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}
		
	}
	
	private Node root; //根节点
	
	/**
	 * 无参构造函数
	 */
	public BinaryTree() {
		root = null;
	}
	
	/**
	 * 传入一个数组来构造二叉树
	 * @param array
	 */
	public BinaryTree(int[] array){
		for(int arr: array){
			insert(arr);
		}
	}
	
	private void insert(int value){
		root = insert(root, value);
	}
	
	/**
	 * 将数值插入二叉树当中，比当前节点小或等于当前节点的左侧，
	 * 比当前节点大的数插在当前节点的右侧，每次从根节点开始递归比较。
	 * @param node 当前节点，就是根节点
	 * @param value 要插入的值
	 * @return 
	 */
	private Node insert(Node node, int value){
		if(node == null){
			node = new Node(null, null, value);
		}else{
			if(value <= node.value){
				node.left = insert(node.right, value);
			}else{
				node.right = insert(node.right, value);
			}
		}
		return node;//?
	}
	
	/**
	 * 访问节点：将节点的值取出来并打印
	 * @param node
	 */
	private void visit(Node node){
		if(node == null){
			return;
		}
		
		int value = node.value;
		System.out.println(value);
	}
	
	/**
	 * 指定节点作为根节点开始递归遍历
	 * @param node
	 */
	private void preOrderTravels(Node node){
		if(node == null){
			return ;
		}else{
			visit(node);
			preOrderTravels(node.left);
			preOrderTravels(node.right);
		}
	}
	
	/**
	 * 从根节点开始对整个树进行先序遍历
	 */
	public void preOrderTravels(){
		preOrderTravels(root);
	}
	
	public Node findNode(Node root, int value){
		while(root != null){
			int currval = root.value;
			if(currval == value) break;
			if(currval < value){
				root = root.right;
			}else{
				root = root.left;
			}
		}
		return root;
	}
	
	//测试
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9,10};  
		BinaryTree bt = new BinaryTree(array);
		bt.preOrderTravels();
	}
}