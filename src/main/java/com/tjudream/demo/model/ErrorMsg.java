package com.tjudream.demo.model;

/**
 * 描述:
 * <p>
 * Created by mengxiansen on 2018-04-08 17:07
 *
 * @author mengxs@lenovocloud.com
 */
public class ErrorMsg {
    public ErrorMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private int code;
    private String msg;

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
}
