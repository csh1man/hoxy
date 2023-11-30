package com.community.hoxy.exception.msg;

public enum ExceptionMsg {
    SUCCESS("SUCCESS"),
    JWT_INVALID_SIGNING("JWT Token's signature is invalid"),
    JWT_DATE_EXPIRED("JWT Token's date is expired."),
    JWT_INVALID_ISSUER("JWT Issuer is invalid"),
    JWT_INVALID_SUBJECT("JWT Subject is invalid");

    private String msg;
    private ExceptionMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
