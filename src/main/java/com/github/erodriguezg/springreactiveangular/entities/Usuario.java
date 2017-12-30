package com.github.erodriguezg.springreactiveangular.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author eduar
 */
public class Usuario implements Serializable {

    private static final long serialVersionUID = 7439126925283605347L;

    private Long idPersona;

    private String username;

    private String password;

    private PerfilUsuario idPerfilUsuario;

    private Persona persona;

    private Boolean habilitado;

    public Usuario() {
        //empty
    }

    public Usuario(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Usuario(Long idPersona, String username) {
        this.idPersona = idPersona;
        this.username = username;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PerfilUsuario getIdPerfilUsuario() {
        return idPerfilUsuario;
    }

    public void setIdPerfilUsuario(PerfilUsuario idPerfilUsuario) {
        this.idPerfilUsuario = idPerfilUsuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idPersona, usuario.idPersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idPersona=" + idPersona +
                ", username='" + username + '\'' +
                ", idPerfilUsuario=" + idPerfilUsuario +
                ", persona=" + persona +
                '}';
    }
}
