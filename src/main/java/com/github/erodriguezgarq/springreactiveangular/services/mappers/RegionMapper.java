package com.github.erodriguezgarq.springreactiveangular.services.mappers;

import com.github.erodriguezgarq.springreactiveangular.documents.Region;
import com.github.erodriguezgarq.springreactiveangular.services.dto.RegionDto;
import org.springframework.stereotype.Component;

@Component
public class RegionMapper {

    public RegionDto toDto(Region region) {
        if(region == null) {
            return null;
        }
        RegionDto regionDto = new RegionDto();
        regionDto.setIdRegion(region.getIdRegion());
        regionDto.setNombre(region.getNombre());
        return regionDto;
    }

}
