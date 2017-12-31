package com.github.erodriguezg.springreactiveangular.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "provincias")
public class Provincia implements Serializable {

    private static final long serialVersionUID = 2538028461418905055L;

    @Id
    private Integer idProvincia;

    private String nombre;

    private Integer idRegion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
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
        Provincia provincia = (Provincia) o;
        return Objects.equals(idProvincia, provincia.idProvincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProvincia);
    }
}
