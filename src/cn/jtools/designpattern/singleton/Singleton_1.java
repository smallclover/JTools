package cn.jtools.designpattern.singleton;

/**
 * Created by smallclover on 2016/6/6.
 * 延迟加载/懒汉模式
 *
 */
public class Singleton_1 {
    private static Singleton_1 singleton_1;

    private Singleton_1(){}

    //该函数存在多线程下不同步的问题
    public static Singleton_1 getInstance(){

        if(singleton_1 != null){
            // do nothing
        }else{
            singleton_1 = new Singleton_1();
        }
        return singleton_1;
    }

    //加synchronized关键字
    public synchronized static Singleton_1 getInstance_1() {

        if(singleton_1 != null){
            // do nothing
        }else{
            singleton_1 = new Singleton_1();
        }
        return singleton_1;
    }
}
