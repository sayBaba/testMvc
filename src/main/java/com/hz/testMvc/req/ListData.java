package com.hz.testMvc.req;

import java.util.List;

public class ListData {

    public List<LoginReq> getData() {
        return data;
    }

    public void setData(List<LoginReq> data) {
        this.data = data;
    }

    List<LoginReq> data;
 }
