package cn.jtools.algorithm;

/**
 * 插入排序
 * 
 * 种类：交换排序
 * 
 * 插入排序是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序的数据，在已排序序列中从后向前扫描，找到相应的位置并插入。
 * 插入排序在实现上，通常采用in-place(即只需要用到O(1)的额外空间的排序)，因而在从后向前的扫描过程中，需要反复把已排序的元素逐渐向后挪，为最新元素提供插入空间。
 * 
 * 算法描述
 * 
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一个位置
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入到该位置后
 * 6.重复步骤2~5
 * 
 * 算法复杂度
 * 
 * 如果目标是把n个元素的序列升序排列，那么采用插入排序存在最好的情况和最坏的情况。
 * 最好的情况就是，序列已经是升序排列了，在这种情况下，需要进行的比较操作(n-1)次即可。
 * 最坏情况就是，序列是降序排列，那么此时需要进行的比较共有n(n-1)/2次。插入排序的赋值操作是比较操作的次数减去(n-1)次。
 * 平均来说插入排序的算法复杂度是O(n2)。因此，插入排序不适合数据量较大的应用。但是，如果数据量较小，例如，量级小于千，那么插入排序还是一个不错的选择。
 * 插入排序在工业级库中也有着广泛的应用，在STL的sort算法和stdlib的qsort算法中，都将插入排序作为快速排序的补充，用于少量元素的排序（通常为8个或以下）。
 * 
 * 
 * 直接插入排序是稳定的排序
 * 如果比较操作的代价比交换操作的代价大的话，可以采用二分查找来减少比较操作的数目，该算法可以认为是插入排序的一个变种，称为二分插入排序
 * @author smartclover
 * 
 */
public class InsertionSort {

	public static int[] sort(int[] array, int length) {
		int i,j,le = length;// 待排序数组的长度
		int key;//待插入的值
		
		//数组的第一个元素(array[0])可以看做已经排好顺序，所以从数组的第二个元素(array[1])开始遍历
		for(i = 1;i < le; i++){
			key = array[i];
			//对已经排好顺序的数组元素从后向前进行遍历，第i个元素是待插入元素，所以遍历从第i-1个元素开始。
			//判断条件有两个1.数组不能越界，要检查数组的下界。2.若待插入的元素小于已经排序的它的前一个元素，把该元素以及之后的元素全部向后移动一位。
			for(j = i - 1;j >=0 && array[j] > key; j--){
				array[j + 1] = array[j]; //向后移动一位
			}
			array[j + 1] = key;//将待排序数值插入
		}
		return array;
	}

	public static void main(String[] args) {
		int[] b = { 4, 3, 8, 1, 9, 0, 2, 7, 6, 5 };
		int[] a = InsertionSort.sort(b, b.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
