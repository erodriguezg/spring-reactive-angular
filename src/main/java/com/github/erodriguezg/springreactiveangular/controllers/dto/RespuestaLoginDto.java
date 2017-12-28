package com.github.erodriguezg.springreactiveangular.controllers.dto;

import java.util.List;

public class RespuestaLoginDto {

    private String token;

    private Boolean exitoLogin;

    private List<String> errores;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getExitoLogin() {
        return exitoLogin;
    }

    public void setExitoLogin(Boolean exitoLogin) {
        this.exitoLogin = exitoLogin;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }
}