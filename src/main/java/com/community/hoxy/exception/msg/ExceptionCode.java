package com.community.hoxy.exception.msg;

public enum ExceptionCode {
    SUCCESS(0),
    JWT_INVALID_SIGNING(100),
    JWT_DATE_EXPIRED(101),
    JWT_INVALID_ISSUER(102),
    JWT_INVALID_SUBJECT(103);

    private int code;
    private ExceptionCode(int code) {
        this.code = code;
    }

    public int getCode() { return this.code; }

    public static ExceptionCode valueOf(int failureCode) {
        ExceptionCode[] list = ExceptionCode.values();
        for(ExceptionCode ec : list) {
            if (ec.getCode() == failureCode) return  ec;
        }
        return null;
    }
}
