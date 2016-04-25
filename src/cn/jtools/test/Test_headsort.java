package cn.jtools.test;

import java.util.Scanner;

public class Test_headsort {
	static int[] arr = new int[101];
	static int n;
	
	static void swap(int x, int y){
		int t;
		t = arr[x];
		arr[x] = arr[y];
		arr[y] = t;
	}
	
	static void siftDown(int i){
		int t, flag = 0;
		while(i * 2 <= n&&flag == 0){
			if(arr[i] > arr[2 * i]){
				t = 2 * i;
			}else{
				t = i;
			}
			
			if(2 * i + 1<= n){
				if(arr[i] > arr[2 * i + 1]){
					t = 2 * i + 1;
				}
			}
			
			if( t != i){
				swap(t, i);
				i = t;
			}else{
				flag = 1;
			}
		}
	}
	
	static void create(){
		for(int i = n/2; i >= 1; i --){
			siftDown(i);
		}
	}
	
	static int deleteMax(){
		int t;
		t = arr[1];
		arr[1] = arr[n];
		n--;
		siftDown(1);
		return t;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i ++){
			arr[i] = sc.nextInt();
		}
		
		n = num;
		
		create();
		
		for(int j = 1; j <= num; j ++){
			System.out.print(deleteMax() + " ");
		}
	}
}
