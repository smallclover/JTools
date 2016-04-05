package cn.jtools.algorithm;
/**
 * 简单的交换排序，每次一遍历找出最小的一个元素
 * @author smallclover
 *
 */
public class NoNameSort {
	
	
	public static void buddleSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length; j++){
				int temp;
				if(arr[j] < arr[i]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
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
		
		buddleSort(arr);
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}			
}
