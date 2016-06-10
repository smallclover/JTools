package cn.jtools.designpattern.singleton;

/**
 * 立即加载/饿汉模式
 * @author smallclover
 *
 */
public class Singleton {
	private static Singleton singleton = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return singleton;
    }
}
