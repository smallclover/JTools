package cn.jtools.base.algorithm.sort;
/**
 * 冒泡排序
 * 
 * 比较相邻两个元素，每一次遍历将一个最大数放到最后
 * @author smallclover
 *
 */
public class BubbleSort {
	//原始版本的冒泡方法，即是顺序排好了还会继续遍历
	public static void buddleSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 1; j < arr.length - i; j++){
				int temp;
				if(arr[j] < arr[j - 1]){
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
			for (int k : arr) {
				System.out.print(k + " ");
			}
			System.out.println();
		}	
	}
	//Test第一个数不用交换？？
	public static void buddleSort2(int[] arr){
		for(int i = 1; i < arr.length - 1; i++){
			for(int j = 1; j < arr.length - i; j++){
				int temp;
				if(arr[j + 1] < arr[j]){
					temp = arr[j ];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			for (int k : arr) {
				System.out.print(k + " ");
			}
			System.out.println();
		}	
	}
	
	
	//通过设置标志符加以优化
	public static void buddleSortAdvanced(int[] arr){
		boolean flag = true;
		for(int i = 0; i < arr.length && flag == true; i++){
			flag = false;
			for(int j = 1; j < arr.length - i; j++){
				int temp;				
				if(arr[j] < arr[j - 1]){
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					flag = true;
				}
			}
			for (int k : arr) {
				System.out.print(k + " ");
			}
			System.out.println();
		}	
	}
	
	
	public static void main(String[] args) {
		int [] arr = {4,3,6,7,8,1,5,9,2,10};
		int [] arr1 = {1,2,3,4,5,6,7,8,9,10};
//		buddleSortAdvanced(arr1);
		buddleSort2(arr1);
//		buddleSort(arr);
//		for (int i : arr) {
//			System.out.print(i + " ");
//		}
	}			
}
