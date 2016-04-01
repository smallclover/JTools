package cn.jtools.algorithm;

/**
 * 快速排序
 * 
 * 种类：交换排序
 * 
 * 在平均状况下，排序n个项目要O(n*log n)次比较。在最坏状况下则需要O(n2)次比较，但这种状况并不常见。
 * 事实上，快速排序通常明显比其他O(n*log n)算法更快，因为它的内部循环(inner loop)可以在大部分架构上有效率地被实现出来。
 * 
 * 算法描述
 * 
 * 快速排序使用分治法(Divide and conquer)策略来吧一个序列(list)分为两个子序列(sub-lists)。
 * 1.从数列中挑出一个元素，称为“基准”(pivot)
 * 2.重新排序数列，所有元素比基准值笑的摆放在基准前面，所有元素比基准值大的摆在基准的后面(相同的数可以到任意一边)。在这分区结束之后，该基准就处于数列的中间位置。这个称为分区(partition)。
 * 3.递归地(recursive)把小于基准值元素的子数列和大于基准值元素的子数列排序
 * 
 * 递归地最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。虽然一直递归小区，但是这个算法总是会结束，
 * 因为在每次迭代(iteration)中，它至少会把一个元素摆到它最后的位置去。
 * 
 * 
 * @author smallclover
 *
 */
public class QuickSort {
	
	static int []array = {6,9,8,7,10,5,2,3,4,1};
	int n;
	
	/**
	 * 交换数组元素
	 * @param x 小于基准元素的下标
	 * @param y 大于基准元素的下标
	 */
	public static void swap(int x, int y){
		int t = array[x];
		array[x] = array[y];
		array[y] = t;
	}
	
	
	public static void quickSort(int left, int right){
		int i,j,t,temp;
		
		//结束递归的条件，当左下标大于右下标的时候
		if(left > right){
			return;
		}
		 
		temp = array[left];//将数组的第一个元素设置为基准
		i =  left;//左哨兵
		j = right;//右哨兵
		
		//从两头开始向中间开始遍历
		while(i != j){
			
			//如果以左边第一个数为基准，遍历必须从数组最后一个数开始遍历，因为遍历最后，基准元素需要与i=j出的元素交换，
			//若从左边遍历，必定会在一个大于基准元素的地方停下，此时交换是不符合规则的。
			//右区间遍历。循环条件
			//1.右区间的值必须大于基准值；2.左哨兵小于右哨兵
			while(array[j] >= temp && i < j){
				j--;
			}
			
			//左区间遍历。循环的条件
			//1.左区间的数必须小于基准值；2.左哨兵小于右哨兵
			while(array[i] <= temp && i < j){
				i++;
			}
			
			//左哨兵小于右哨兵，交换下标所对应的值
			if(i < j){
				swap(i, j);
			}
		}
		
		//交换基准元素与左哨兵和右哨兵相遇位置的元素
		array[left] = array[i];
		array[j] = temp;
		
		//左区间递归
		quickSort(left, i - 1);
		//右区间递归
		quickSort(i + 1, right);
	}
	
	public static void main(String[] args) {
		quickSort(0, array.length - 1);
		
		System.out.println("result:");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
}
