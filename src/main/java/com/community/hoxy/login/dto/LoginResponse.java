package com.community.hoxy.login.dto;

public class LoginResponse {
    private int rspCode;
    private String rspMsg;

    public LoginResponse(int rspCode, String rspMsg){
        this.rspCode = rspCode;
        this.rspMsg = rspMsg;
    }

    public int getRspCode() {
        return rspCode;
    }

    public void setRspCode(int rspCode) {
        this.rspCode = rspCode;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }
}
