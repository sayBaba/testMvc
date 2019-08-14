package com.hz.testMvc.req;

public class LoginReq {

    private String userName;
    private String password;

    public String[] getItem_id() {
        return item_id;
    }

    public void setItem_id(String[] item_id) {
        this.item_id = item_id;
    }

    String[] item_id;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
