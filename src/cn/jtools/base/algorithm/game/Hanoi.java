package cn.jtools.base.algorithm.game;
/**
 * 汉诺塔
 * @author smallclover
 *
 */
public class Hanoi {
	
	static void move(int n, char x, char y, char z){
		
		if(n == 1){
			System.out.println(x+"-->"+z);
		}else{
			move(n - 1, x, z, y);
			System.out.println(x+"-->"+z);
			move(n - 1,y, x , z);
		}
	}
	
	public static void main(String[] args) {
		move(3, 'X', 'Y', 'Z');
	}
	
	
}
