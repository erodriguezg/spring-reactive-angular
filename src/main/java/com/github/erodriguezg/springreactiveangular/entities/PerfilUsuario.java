package com.github.erodriguezg.springreactiveangular.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author eduar
 */
public class PerfilUsuario implements Serializable {

    private static final long serialVersionUID = -4539784086246915572L;

    private Integer idPerfilUsuario;

    private String nombre;

    private Set<Usuario> usuarioSet;

    public PerfilUsuario() {
    }

    public PerfilUsuario(Integer idPerfilUsuario) {
        this.idPerfilUsuario = idPerfilUsuario;
    }

    public PerfilUsuario(Integer idPerfilUsuario, String nombre) {
        this.idPerfilUsuario = idPerfilUsuario;
        this.nombre = nombre;
    }

    public Integer getIdPerfilUsuario() {
        return idPerfilUsuario;
    }

    public void setIdPerfilUsuario(Integer idPerfilUsuario) {
        this.idPerfilUsuario = idPerfilUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Usuario> getUsuarioSet() {
        return usuarioSet;
    }

    public void setUsuarioSet(Set<Usuario> usuarioSet) {
        this.usuarioSet = usuarioSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerfilUsuario that = (PerfilUsuario) o;
        return Objects.equals(idPerfilUsuario, that.idPerfilUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerfilUsuario);
    }

    @Override
    public String toString() {
        return "PerfilUsuario{" +
                "idPerfilUsuario=" + idPerfilUsuario +
                ", nombre='" + nombre + '\'' +
                ", usuarioSet=" + usuarioSet +
                '}';
    }
}
