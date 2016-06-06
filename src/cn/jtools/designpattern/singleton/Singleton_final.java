package cn.jtools.designpattern.singleton;

/**
 * Created by smallclover on 2016/6/6.
 * Double-Check Locking 双重锁检查机制
 *
 */
public class Singleton_final {
   private volatile static Singleton_final singleton_final;
//    private static Singleton_final singleton_final;
    private Singleton_final(){
    }

    public static Singleton_final getInstance() {

        if(singleton_final != null){
            //do nothing
        }else {
            synchronized (Singleton_final.class){
                if (singleton_final == null){
                    singleton_final = new Singleton_final();
                }
            }
        }
        return singleton_final;
    }
}
