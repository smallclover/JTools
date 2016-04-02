package cn.jtools.algorithm;
/**
 * 冒泡排序
 * @author smallclover
 *
 */
public class BuddleSort {
	
	
	public static void buddleSort(int[] arr){
		for(int i = 0;i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){
				int temp;
				if(arr[j] < arr[i]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
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
