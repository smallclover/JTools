package cn.jtools.util;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * Created by smallclover on 2016/7/9.
 */
public class CloneUtil {

    /**
     * 深克隆，使用序列化的方式。
     * @param obj
     * @param <T>
     * @return
     */
    public static<T extends Serializable> T clone(T obj){
        T cloneObj = null;
        try {

            //写入字节流
            ByteOutputStream out = new ByteOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(obj);
            oos.close();
            //分配内存，写入原始对象，生成新的对象
            ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            //返回新生成的对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cloneObj;
    }
}
