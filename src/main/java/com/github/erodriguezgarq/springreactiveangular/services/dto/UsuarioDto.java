package com.github.erodriguezgarq.springreactiveangular.services.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by erodriguezg on 02-07-17.
 */
public class UsuarioDto implements Serializable {

    private static final long serialVersionUID = -7269724950105299998L;

    private String username;

    private Boolean habilitado;

    private String password;

    private PerfilDto perfil;

    private PersonaDto persona;

    public UsuarioDto() {
        //vacio
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public PerfilDto getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDto perfil) {
        this.perfil = perfil;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "username='" + username + '\'' +
                ", habilitado=" + habilitado +
                ", password='" + password + '\'' +
                ", perfil=" + perfil +
                ", persona=" + persona +
                '}';
    }
}
