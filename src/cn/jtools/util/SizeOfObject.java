package cn.jtools.util;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by smallclover on 2016/4/28.
 */
public class SizeOfObject {
    static Instrumentation inst;

    public static void premain(String args, Instrumentation intsp){
        inst = intsp;
    }

    public static long sizeof(Object obj){
        return inst.getObjectSize(obj);
    }

    public static long fullSizeOf(Object objP) throws IllegalAccessException {
        Set<Object> visited = new HashSet<>();
        Deque<Object> toBeQueue = new ArrayDeque<>();
        toBeQueue.add(objP);
        long size = 0L;
        while (toBeQueue.size() > 0){
            Object obj = toBeQueue.poll();
            size += skipObject(visited, obj) ? 0L:sizeof(obj);
            Class<?> tmpObjClass = obj.getClass();
            if(tmpObjClass.isArray()){
                if(tmpObjClass.getName().length() > 2){
                    for (int i = 0, len = Array.getLength(obj); i < len; i++){
                        Object tmp = Array.get(obj, i);
                        if(tmp != null){
                            toBeQueue.add(Array.get(obj, i));
                        }
                    }
                }
            }else{
                while(tmpObjClass != null){
                    Field[] fields = tmpObjClass.getDeclaredFields();
                    for (Field field:fields){
                        if(Modifier.isStatic(field.getModifiers())|| field.getType().isPrimitive()){
                            continue;
                        }

                        field.setAccessible(true);
                        Object fieldVaule = field.get(obj);
                        if(fieldVaule == null){
                            continue;
                        }
                        toBeQueue.add(fieldVaule);
                    }
                    tmpObjClass = tmpObjClass.getSuperclass();
                }
            }
        }
        return size;
    }

    public static boolean skipObject(Set<Object> visited, Object obj){
        if(obj instanceof String && obj == ((String) obj).intern()){
            return true;
        }
        return visited.contains(obj);
    }
}
