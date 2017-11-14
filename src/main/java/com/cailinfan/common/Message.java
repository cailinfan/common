package com.cailinfan.common;

/**
 * 简单消息类
 * Created by cailinfan on 2017/4/4.
 */
public class Message {

    /**
     * 自定义消息码
     */
    private String code;

    /**
     * 用户可理解的错误信息，需本地化
     */
    private String message;

    public Message(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
