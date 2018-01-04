package com.github.erodriguezgarq.springreactiveangular.controllers.dto;

import java.io.Serializable;

public class RefreshTokenDto implements Serializable {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
