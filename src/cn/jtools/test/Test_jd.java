package cn.jtools.test;

import java.util.Scanner;

public class Test_jd {
	static int [] array = new int[101];
	static int num = 0;
	static int count = 0;
	public static void main(String[] args) {
		while(true){
			for(int m = 0; m < 101; m++){
				array[m] = 0;
			}
			num = 0;
			count = 0;
				Scanner sc = new Scanner(System.in);
				num = sc.nextInt();
				for(int i =0; i < num; i++){
						array[i] = sc.nextInt();
				}	
				for(int j = 1; j < num; j++){
					quickSort(1, num - 1);
				}
				meid(array);
		}

	}
	
	public static void meid(int[] arr){	
		if(array[0] > array[num - 1]){
			System.out.print(count);
			return;
		}
		array[0] += 1;
		array[num - 1] -= 1;
		count++;
		quickSort(1, num - 1);
		meid(array);
	}
	
	
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
	
	
}
