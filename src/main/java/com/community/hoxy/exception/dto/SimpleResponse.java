package com.community.hoxy.exception.dto;

import com.community.hoxy.exception.msg.ExceptionCode;
import com.community.hoxy.exception.msg.ExceptionMsg;

public class SimpleResponse {
    private int rspCode;
    private String  rspMsg;

    public SimpleResponse(int rspCode, String rspMsg){
        this.rspCode = rspCode;
        this.rspMsg  = rspMsg;
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
