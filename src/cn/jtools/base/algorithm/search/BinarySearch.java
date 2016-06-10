package cn.jtools.base.algorithm.search;

import java.util.Arrays;

/**
 * 二分查找
 * @author smallclover
 *
 */
public class BinarySearch {
	static int[] array = {3,5,10,9,7,8,4,1,2,6};
	static int mid;
	static int key = 2;
	static void binarySearch(int head, int tail){
//		mid = (head +tail)/2+1;
		
		mid = ((head + tail) >> 1)+1;//右移2位表示除2，左移2位表示乘2
		if(key == array[mid]){
			System.out.println("Success! index = "+mid);
		}else if(key < array[mid]){
			binarySearch(head, mid - 1);
		}else{
			binarySearch(mid + 1, tail);
		}
	}

	public static void main(String[] args) {
		Arrays.sort(array);
		binarySearch(0, 9);
//		System.out.println(3 >> 1);
	}
}
