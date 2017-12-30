package com.github.erodriguezg.springreactiveangular.entities;

import java.io.Serializable;
import java.util.Objects;

public class Provincia implements Serializable {

    private static final long serialVersionUID = -4339008590656387006L;

    private Integer id;

    private String nombre;

    private Region region;

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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return Objects.equals(id, provincia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
