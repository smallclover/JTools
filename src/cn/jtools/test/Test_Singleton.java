package cn.jtools.test;

import cn.jtools.designpattern.Singleton_final;

/**
 * 饿汉单例模式测试
 *
 */
public class Test_Singleton {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();
        MyThread t6 = new MyThread();
        MyThread t7 = new MyThread();
        MyThread t8 = new MyThread();
        MyThread t9 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
    }
}

class MyThread extends Thread{

    @Override
    public void run() {
       // System.out.println(Singleton.getInstance().hashCode());//饿汉模式
       // System.out.println(Singleton_1.getInstance().hashCode());//懒汉模式
       // System.out.println(Singleton_1.getInstance_1().hashCode());//懒汉模式（同步）
        System.out.println(Singleton_final.getInstance().hashCode());
    }
}