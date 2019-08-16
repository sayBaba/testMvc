package com.hz.testMvc.resp;

import java.util.List;

/**
 * 查询返回共用类
 */
public class ResponseData {


    private List<UserData> data;

    private String code = "0";

    private String msg;

    private Integer count =0;

    public List<UserData> getData() {
        return data;
    }

    public void setData(List<UserData> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }



}
