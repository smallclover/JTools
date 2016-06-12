package cn.jtools.exception;

/**
 * Created by smallclover on 2016/6/12.
 * 普通异常
 */
public class GenerateException extends RuntimeException{

    public GenerateException(){ super(); }

    public GenerateException(String errorMessage){
        super(errorMessage);
    }

    public GenerateException(String errorMessage,Throwable error){
        super(errorMessage, error);
    }
}

class Test{
    public static void main(String[] args) throws GenerateException {
        throw new GenerateException("nihao");
    }
}