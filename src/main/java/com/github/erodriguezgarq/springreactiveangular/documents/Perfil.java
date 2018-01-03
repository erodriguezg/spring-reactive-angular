package com.github.erodriguezgarq.springreactiveangular.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * @author eduar
 */
@Document(collection = "perfiles")
public class Perfil implements Serializable {

    private static final long serialVersionUID = -4539784086246915572L;

    @Id
    private BigInteger id;

    @Indexed(unique = true)
    @Field("idPerfil")
    private Integer idPerfil;

    @Field("nombre")
    private String nombre;

    public Perfil() {
    }

    public Perfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil that = (Perfil) o;
        return Objects.equals(idPerfil, that.idPerfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerfil);
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "idPerfil=" + idPerfil +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
