package com.github.erodriguezg.springreactiveangular.services.mappers;

import com.github.erodriguezg.springreactiveangular.documents.Perfil;
import com.github.erodriguezg.springreactiveangular.documents.Persona;
import com.github.erodriguezg.springreactiveangular.documents.Usuario;
import com.github.erodriguezg.springreactiveangular.services.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by eduar on 05/07/2017.
 */
@Component
public class UsuarioMapper {

    @Autowired
    private PerfilMapper perfilMapper;

    public UsuarioDto toUsuarioDto(Usuario usuario, Persona persona, Perfil perfil) {
        if (usuario == null) {
            return null;
        }
        UsuarioDto dto = new UsuarioDto();
        dto.setApMaterno(persona.getApellidoMaterno());
        dto.setApPaterno(persona.getApellidoPaterno());
        dto.setEmail(persona.getEmail());
        dto.setFechaNacimiento(persona.getFechaNacimiento());
        dto.setHabilitado(usuario.getHabilitado());
        dto.setNombres(persona.getNombres());
        dto.setPassword(usuario.getPassword());
        dto.setPerfil(perfilMapper.toPerfilDto(perfil));
        dto.setRut(persona.getRun());
        dto.setUsername(usuario.getUsername());
        return dto;
    }

    public Usuario toUsuario(UsuarioDto dto) {
        if (dto == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        Persona persona = new Persona();
        usuario.setRunPersona(dto.getRut());
        usuario.setIdPerfil(dto.getPerfil().getId());
        persona.setApellidoMaterno(dto.getApMaterno());
        persona.setApellidoPaterno(dto.getApPaterno());
        persona.setEmail(dto.getEmail());
        persona.setFechaNacimiento(dto.getFechaNacimiento());
        persona.setNombres(dto.getNombres());
        persona.setRun(dto.getRut());
        usuario.setUsername(dto.getUsername());
        usuario.setHabilitado(dto.getHabilitado());
        usuario.setPassword(dto.getPassword());
        return usuario;
    }
}
