package cn.jtools.test;

/**
 * 姑且可以成为简单的桶排序
 * @author smallclover
 *
 */
public class Test_Sort {
	public static void sort(int[] array, int len){
		int [] arr = new int[len];
		
		
		//数组的初始化
		for(int i = 0; i < arr.length; i++){
			arr[i] = 0;
		}
		
		//将数放到桶里
		for(int j = 0; j < array.length; j++){
			arr[array[j]] += 1;
		}

		//从小到大排序
		for(int k = 0; k < arr.length;k++){
			for(int n = 0; n < arr[k]; n++){
				System.out.println(k);
			}
		}
		//从大到小排序
		for(int k = arr.length - 1; k > 0;k--){
			for(int n = 0; n < arr[k]; n++){
				System.out.println(k);
			}
		}

	}
	
	public static void main(String[] args) {
		int[] array = { 10, 9, 9, 3, 5, 5, 1, 2, 3, 5, 6, 8 };

		sort(array, array.length);
	}
}
