package com.community.hoxy.login.dto;

public class TokenInfo {
    private String accessToken;
    private String tokenType;

    public TokenInfo(String accessToken){
        this.accessToken = accessToken;
        this.tokenType = "bearer";
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
