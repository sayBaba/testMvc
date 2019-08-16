package com.hz.testMvc.req;

/**
 * 分页参数
 */
public class PageReq {

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }


    private String page;

    private String limit;

}
