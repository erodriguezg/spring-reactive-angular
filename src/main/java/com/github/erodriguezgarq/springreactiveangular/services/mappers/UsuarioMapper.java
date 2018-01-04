package com.github.erodriguezgarq.springreactiveangular.services.mappers;

import com.github.erodriguezgarq.springreactiveangular.documents.Perfil;
import com.github.erodriguezgarq.springreactiveangular.documents.Persona;
import com.github.erodriguezgarq.springreactiveangular.documents.Usuario;
import com.github.erodriguezgarq.springreactiveangular.services.dto.PerfilDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.PersonaDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by eduar on 05/07/2017.
 */
@Component
public class UsuarioMapper {

    @Autowired
    private PerfilMapper perfilMapper;

    public UsuarioDto toUsuarioDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        UsuarioDto dto = new UsuarioDto();
        dto.setHabilitado(usuario.getHabilitado());
        dto.setPerfil(new PerfilDto(usuario.getIdPerfil()));
        dto.setPersona(new PersonaDto(usuario.getRunPersona()));
        dto.setUsername(usuario.getUsername());
        dto.setPassword(usuario.getPassword());
        return dto;
    }

    public Usuario toUsuario(UsuarioDto dto) {
        if (dto == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setRunPersona(dto.getPersona().getRun());
        usuario.setIdPerfil(dto.getPerfil().getId());
        usuario.setUsername(dto.getUsername());
        usuario.setHabilitado(dto.getHabilitado());
        usuario.setPassword(dto.getPassword());
        return usuario;
    }
}
