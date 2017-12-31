package com.github.erodriguezg.springreactiveangular.services.mappers;

import com.github.erodriguezg.springreactiveangular.documents.Perfil;
import com.github.erodriguezg.springreactiveangular.services.dto.PerfilDto;
import org.springframework.stereotype.Component;

@Component
public class PerfilMapper {

    public PerfilDto toPerfilDto(Perfil entidad) {
        PerfilDto dto = new PerfilDto();
        if(entidad != null) {
            dto.setId(entidad.getIdPerfil());
            dto.setNombre(entidad.getNombre());
        }
        return dto;
    }

    public Perfil toPerfilUsuario(PerfilDto dto) {
        Perfil entidad = new Perfil();
        if(dto == null) {
            return null;
        }
        entidad.setIdPerfil(dto.getId());
        entidad.setNombre(dto.getNombre());
        return entidad;
    }
}
