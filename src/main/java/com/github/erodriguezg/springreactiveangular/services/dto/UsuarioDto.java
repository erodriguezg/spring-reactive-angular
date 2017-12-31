package com.github.erodriguezg.springreactiveangular.services.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by erodriguezg on 02-07-17.
 */
public class UsuarioDto implements Serializable {

    private static final long serialVersionUID = -1118062591140816905L;

    private Long idPersona;

    private String username;

    private Integer rut;

    private String nombres;

    private String apPaterno;

    private String apMaterno;

    private String password;

    private String email;

    private Date fechaNacimiento;

    private Boolean habilitado;

    private PerfilDto perfil;

    public UsuarioDto() {
        //vacio
    }

    public UsuarioDto(Long idPersona) {
        this.idPersona = idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdPersona() {
        return this.idPersona;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public Integer getRut() {
        return this.rut;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Boolean getHabilitado() {
        return this.habilitado;
    }

    public PerfilDto getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDto perfil) {
        this.perfil = perfil;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDto that = (UsuarioDto) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

}
