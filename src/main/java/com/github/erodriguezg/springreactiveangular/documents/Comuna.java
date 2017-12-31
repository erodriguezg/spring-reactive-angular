package com.github.erodriguezg.springreactiveangular.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document
public class Comuna implements Serializable {

    private static final long serialVersionUID = -23184362700093696L;

    @Id
    private Integer id;

    private String nombre;

    private Integer idProvincia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comuna comuna = (Comuna) o;
        return Objects.equals(id, comuna.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
