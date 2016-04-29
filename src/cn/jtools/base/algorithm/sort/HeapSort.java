package cn.jtools.base.algorithm.sort;

/**
 * 堆排序
 * 
 * 对包含N个元素的数列构造堆的步骤
 * 1. 令 I = N/2, T = I
 * 2. 若 I >= 1, 则重复下面步骤3
 * 3. 比较D(T),D(2T),D(2T + 1)
 * D(T)最大时，令I = I - 1，T = 1
 * D(2T)最大时，D(T)和D(2T)交换，令T = 2T
 * D(2T + 1)最大时，D(T)和D(2T + 1)交换，令T = 2T + 1
 * 叶子D(2T),D(2T + 1)不存在时，令I = I - 1, T = 1
 * @author smallclover
 *
 */
public class HeapSort {
		public static void heapSort(int[] data){
			for(int i = 0; i < data.length; i ++){
				createMaxHeap(data, data.length - 1 - i);
				swap(data, 0, data.length - 1 - i);
				print(data);
			}
		}
		
		private static void swap(int[] data, int i, int j){
			if(i == j){
				return;
			}
			
			data[i] = data[i] + data[j];
			data[j] = data[i] - data[j];
			data[i] = data[i] - data[j];
		}
		
		
		private static void createMaxHeap(int[] data, int lastIndex){
			for(int i = (lastIndex - 1)/2; i >= 0; i--){
				//保存当前正在判断的节点
				int k = i;
				//若当前结点存在
				while(2 * k + 1 <= lastIndex){
					//biggerIndex总是记录较大节点的值，先赋值为当前判断节点的左节点
					int biggerIndex = 2 * k + 1;
					if(biggerIndex < lastIndex){
						//若右子节点存在，否则此时biggerIndex应该等于lastIndex
						if(data[biggerIndex] < data[biggerIndex + 1]){
							//若右子节点比左子节点值大，则biggerIndex记录的应该是右子节点
							biggerIndex++;
						}
					}
					
					//若当前的节点值比左子节点值大，则交换两者的值，交换后biggerIndex值赋给k
					if(data[k] < data[biggerIndex]){
						swap(data, k, biggerIndex);
						k = biggerIndex;
					}else{
						break;
					}
				}
			}
		}
		
		private static void print(int[] data){
			for(int i = 0; i < data.length; i ++){
				System.out.print(data[i] + "\t");
			}
			System.out.println();
		}
		
		public static void main(String[] args) {
	        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };  
	        print(data5);  
	        heapSort(data5);  
	        System.out.println("排序后的数组：");  
	        print(data5);  
		}
}
