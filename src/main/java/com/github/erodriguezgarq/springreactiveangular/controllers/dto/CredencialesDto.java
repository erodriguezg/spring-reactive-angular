package com.github.erodriguezgarq.springreactiveangular.controllers.dto;

import java.io.Serializable;

public class CredencialesDto implements Serializable {
    
    private String rut;
    
    private String password;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}