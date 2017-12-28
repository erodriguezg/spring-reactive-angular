package com.github.erodriguezg.springreactiveangular.services;


import com.github.erodriguezg.springreactiveangular.services.dto.UsuarioDto;
import com.github.erodriguezg.springreactiveangular.services.dto.UsuarioFiltroDto;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> traerTodos();

    UsuarioDto guardarUsuario(UsuarioDto usuario);

    UsuarioDto traerPorUsername(String username);

    List<UsuarioDto> buscar(UsuarioFiltroDto filterDto);

    void eliminar(UsuarioDto usuario, Long idPersonaIdentidad);

    void habilitar(UsuarioDto usuario);

    void deshabilitar(UsuarioDto usuario, Long idUsuarioActual);

    UsuarioDto traerPorRun(Integer run);
}