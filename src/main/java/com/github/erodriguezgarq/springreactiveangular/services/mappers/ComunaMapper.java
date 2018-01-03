package com.github.erodriguezgarq.springreactiveangular.services.mappers;

import com.github.erodriguezgarq.springreactiveangular.documents.Comuna;
import com.github.erodriguezgarq.springreactiveangular.services.dto.ComunaDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.ProvinciaDto;
import org.springframework.stereotype.Component;

@Component
public class ComunaMapper {

    public ComunaDto toDto(Comuna comuna) {
        if(comuna == null) {
            return null;
        }
        ComunaDto comunaDto = new ComunaDto();
        comunaDto.setIdComuna(comuna.getIdComuna());
        comunaDto.setNombre(comuna.getNombre());
        comunaDto.setProvinciaDto(new ProvinciaDto(comuna.getIdProvincia()));
        return comunaDto;
    }

}
