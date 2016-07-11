package cn.jtools.base.algorithm.game;

import java.util.Scanner;

/**
 * Created by smallclover on 2016/7/11.
 * 迷宫 代码来自啊哈算法
 */
public class Maze {
    public static int n;//x轴边界
    public static int m;//y轴边界
    public static int p;//目标所在位置的x坐标
    public static int q;//目标所在位置的y坐标
    public static int min = 99999999;
    public static int[][] a = new int[51][51];
    public static int[][] book = new int[51][51];

    /**
     *
     * @param x x坐标
     * @param y y坐标
     * @param step 当前已经走过的步数
     */
    public static void dfs(int x, int y, int step){
                        //右     下      左     上
        int [][] next = {{0,1},{1,0},{0,-1},{-1,0}};
        int tx,ty,k;

        //判断是否达到目标的位置 （判断边界）
        if (x == p && y == q){

            //更新最小值
            if (step < min){
                min = step;
            }

            return;
        }

        //循环获得下一步的坐标
        for (k = 0; k <= 3; k++){

            //计算下一个点的坐标
            tx = x + next[k][0];
            ty = y + next[k][1];

            //判断是否越界
            if (tx < 1 || tx > n || ty < 1 || ty > m){
                continue;
            }

            //判断该点是否为障碍物或者已经在路径中
            if (a[tx][ty] == 0 && book[tx][ty] == 0){
                book[tx][ty] = 1; //标记这个点已经走过
                dfs(tx, ty, step + 1);//开始尝试下一个点
                book[tx][ty] = 0;//尝试结束，取消这个点的标记
            }
        }

        return;
    }

    public static void main(String[] args) {
        int i,j,startx,starty;
        Scanner sc = new Scanner(System.in);
        //读入n和m,n为行，m为列
        n = sc.nextInt();
        m = sc.nextInt();
        //读入迷宫
        for(i = 1; i <= n; i++){
            for (j = 1; j <= m; j++){
                a[i][j] = sc.nextInt();
            }
        }

        //读入终点和起点坐标
        startx = sc.nextInt();
        starty = sc.nextInt();
        p = sc.nextInt();
        q = sc.nextInt();

        book[startx][starty] = 1;//标记起点已经在路径中，防止后面重复走
        dfs(startx, starty, 0);//第一个参数是起点的x坐标，第二个参数是起点的y坐标，第三个参数时初始步数为0

        //输出最短步数
        System.out.println(min);
        return;
    }

    public static void Test(){
        int[][] array = {{0,1}};
        System.out.println(array[0][1]);
    }
}
