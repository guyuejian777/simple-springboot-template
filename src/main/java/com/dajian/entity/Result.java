package com.dajian.entity;

import java.io.Serializable;

/**
 * @author 86156
 * @date 2019/7/21
 */
public class Result implements Serializable {
    //判断结果
    private boolean success;
    //返回信息
    private  String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public Result(){

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
