package com.github.erodriguezg.springreactiveangular.documents;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "regiones")
public class Region implements Serializable {

    private static final long serialVersionUID = 300006723213976827L;

    private Integer idRegion;

    private String nombre;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(idRegion, region.idRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegion);
    }
}
