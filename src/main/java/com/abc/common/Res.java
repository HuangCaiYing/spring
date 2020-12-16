package com.abc.common;

import lombok.Data;

@Data
public class Res<T> {
    private int status;
    private String msg;
    private T data;

    private Res(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    private Res(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    //success
    public static <T> Res<T> success(ResEnum re, T data){
        return new Res<T>(re.getStatus(),re.getMgs(),data);
    }
    public static  Res success(ResEnum re){
        return new Res(re.getStatus(),re.getMgs());
    }
    public static  Res success(){
        return new Res(ResEnum.SUCCESS.getStatus(),ResEnum.SUCCESS.getMgs());
    }

    //error
    public static <T> Res<T> error(ResEnum re, T data){
        return new Res<T>(re.getStatus(),re.getMgs(),data);
    }
    public static  Res error(ResEnum re){
        return new Res(re.getStatus(),re.getMgs());
    }
    public static  Res error(){
        return new Res(ResEnum.ERROR.getStatus(),ResEnum.ERROR.getMgs());
    }
}
