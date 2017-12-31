package com.github.erodriguezg.springreactiveangular.services.dto;

import java.io.Serializable;
import java.util.Objects;

public class ComunaDto implements Serializable {

    private static final long serialVersionUID = 2820726649313714968L;

    private Integer idComuna;

    private String nombre;

    private ProvinciaDto provinciaDto;

    public Integer getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Integer idComuna) {
        this.idComuna = idComuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProvinciaDto getProvinciaDto() {
        return provinciaDto;
    }

    public void setProvinciaDto(ProvinciaDto provinciaDto) {
        this.provinciaDto = provinciaDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComunaDto comunaDto = (ComunaDto) o;
        return Objects.equals(idComuna, comunaDto.idComuna);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComuna);
    }
}
