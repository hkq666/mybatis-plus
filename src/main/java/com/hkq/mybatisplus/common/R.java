package com.hkq.mybatisplus.common;

/**
 * @author huangkaiqiang
 * @version 1.0
 * @description 自定义返回类型
 * @date 2020/9/10 14:40
 */
public class R<T> {
    private int code;
    private T data;

    public R(int code,T data){
        this.code = code;
        this.data = data;
    }

    public static <T> R<T> ok(){
        return new R<T>(200,null);
    }

    public static <T> R<T> ok(T data){
       return new R<T>(200,data);
    }
}
