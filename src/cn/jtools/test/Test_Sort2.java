package cn.jtools.test;

public class Test_Sort2 {
	public static int[] arr = {6,1,2,7,9,2,3,4,4,5,4,5,10,8};
	
	/**
	 * 
	 * @param left
	 * @param right
	 */
	public static void quickSort(int left, int right){
		
		int i = left;
		int j = right;
		int temp;
		if(left > right){
			return;
		}
		while(j > i){
			int stand = arr[left];
			while(j >= 0 && i < j){
				if(arr[j] < stand){
					break;
				}
				j--;
			}
			
			while(i <= arr.length - 1&&i < j){
				if(arr[i] > stand){
					break;
				}
				i++;
			}
						
			if(j != i){
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		temp = arr[left];
		arr[left] = arr[j];
		arr[j] = temp;
		quickSort(left, j - 1);
		quickSort(i + 1,right);		
	}
	
	
	public static void main(String[] args) {
		quickSort(0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
