package com.github.erodriguezg.springreactiveangular.services.dto;

import java.io.Serializable;
import java.util.Objects;

public class RegionDto implements Serializable {

    private static final long serialVersionUID = -351862481296502114L;

    private Integer idRegion;

    private String nombre;

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
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
        RegionDto regionDto = (RegionDto) o;
        return Objects.equals(idRegion, regionDto.idRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegion);
    }
}
