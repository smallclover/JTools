package cn.jtools.algorithm;

/**
 * 快速排序
 * @author smallclover
 *
 */
public class QuickSort {
	
	static int []a = {6,9,8,7,10,5,2,3,4,1};
	int n;
	public static void quickSort(int left, int right){
		int i,j,t,temp;
		
		if(left > right){
			return;
		}
		
		temp = a[left];
		i =  left;
		j = right;
		while(i != j){
			
			while(a[j] >= temp && i < j){
				j--;
			}
			
			while(a[i] <= temp && i < j){
				System.out.println("i:"+i+"  a["+i+"]:"+a[i]);
				i++;
			}
/*			
			while(a[j] >= temp && i < j){
				System.out.println("j:"+j+"  a["+j+"]:"+a[j]);
				j--;
			}*/
			if(i < j){
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			
			for(int k = 0; k < a.length; k++){
				System.out.print(a[k]+" ");
			}
			System.out.println();
		}
		
		a[left] = a[i];
		a[j] = temp;
		quickSort(left, i - 1);
		quickSort(i + 1, right);
	}
	
	public static void main(String[] args) {
		quickSort(0, a.length - 1);
		
		System.out.println("result:");
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
}
