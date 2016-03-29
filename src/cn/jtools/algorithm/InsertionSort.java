package cn.jtools.algorithm;

/**
 * 插入排序
 * 
 * @author smartclover
 * 
 */
public class InsertionSort {

	public static int[] sort(int[] arrays, int length) {
		int le = length;// 待排序数组的长度

		// 从第数组的第二个元素开始遍历
		for (int j = 1; j < le; j++) {
			int key = arrays[j];// 将当前需要排序的值赋给一个临时变量key
			int i = j - 1;// 获得此次遍历的上界

			// 从上界开始向前遍历
			while (i >= 0 && arrays[i] > key) {
				// 将比key值大的值向后移动一个位置
				arrays[i + 1] = arrays[i];
				i--;
			}
			// 将key插入正确位置
			arrays[i + 1] = key;
		}
		return arrays;
	}

	public static void main(String[] args) {
		int[] b = { 4, 3, 8, 1, 9, 0, 2, 7, 6, 5 };
		int[] a = InsertionSort.sort(b, b.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
