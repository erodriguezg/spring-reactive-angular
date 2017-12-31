package com.github.erodriguezg.springreactiveangular.services.dto;

import java.io.Serializable;
import java.util.Objects;

public class ProvinciaDto implements Serializable {

    private static final long serialVersionUID = 3801302561773102294L;

    private Integer idProvincia;

    private String noombre;

    private RegionDto regionDto;

    public ProvinciaDto(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNoombre() {
        return noombre;
    }

    public void setNoombre(String noombre) {
        this.noombre = noombre;
    }

    public RegionDto getRegionDto() {
        return regionDto;
    }

    public void setRegionDto(RegionDto regionDto) {
        this.regionDto = regionDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProvinciaDto that = (ProvinciaDto) o;
        return Objects.equals(idProvincia, that.idProvincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProvincia);
    }
}
