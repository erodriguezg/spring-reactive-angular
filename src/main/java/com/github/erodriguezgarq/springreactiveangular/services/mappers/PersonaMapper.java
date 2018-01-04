package com.github.erodriguezgarq.springreactiveangular.services.mappers;

import com.github.erodriguezgarq.springreactiveangular.documents.Persona;
import com.github.erodriguezgarq.springreactiveangular.services.dto.PersonaDto;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {

    public PersonaDto toDto(Persona persona) {
        if(persona == null) {
            return null;
        }
        PersonaDto dto = new PersonaDto();
        dto.setRun(persona.getRun());
        dto.setApPaterno(persona.getApellidoPaterno());
        dto.setApMaterno(persona.getApellidoMaterno());
        dto.setEmail(persona.getEmail());
        dto.setFechaNacimiento(persona.getFechaNacimiento());
        dto.setNombres(persona.getNombres());
        return dto;
    }

}
