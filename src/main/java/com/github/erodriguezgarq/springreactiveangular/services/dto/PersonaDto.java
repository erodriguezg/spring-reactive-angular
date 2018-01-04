package com.github.erodriguezgarq.springreactiveangular.services.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonaDto implements Serializable {

    private Integer run;

    private String nombres;

    private String apPaterno;

    private String apMaterno;

    private String email;

    private Date fechaNacimiento;

    public PersonaDto() {
    }

    public PersonaDto(Integer run) {
        this.run = run;
    }

    public Integer getRun() {
        return run;
    }

    public void setRun(Integer run) {
        this.run = run;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaDto that = (PersonaDto) o;
        return Objects.equals(run, that.run);
    }

    @Override
    public int hashCode() {
        return Objects.hash(run);
    }
}
