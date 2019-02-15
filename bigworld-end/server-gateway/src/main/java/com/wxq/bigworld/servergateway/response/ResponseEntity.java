package com.wxq.bigworld.servergateway.response;

/**
 * 返回结果
 *
 */
public class ResponseEntity {

    /** 状态码 */
    private int code;

    /** 提示语 */
    private String msg;
    //    token
    private String token;

    /** 返回数据 */
    private Object data;

    public ResponseEntity() {
    }


    public ResponseEntity(int code, String msg, String token) {
        this.code = code;
        this.msg = msg;
        this.token = token;
    }

    public ResponseEntity(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseEntity data(Object data) {
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
