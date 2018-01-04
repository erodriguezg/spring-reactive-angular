package com.github.erodriguezgarq.springreactiveangular.services;


import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioFiltroDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioService {

    Mono<UsuarioDto> traerPorUsernameConPerfilYPersona(String username);

    Mono<UsuarioDto> traerPorRun(Integer run);

    Flux<UsuarioDto> buscar(UsuarioFiltroDto filterDto);

    Mono<UsuarioDto> guardar(UsuarioDto usuario);

    Mono<Void> eliminar(UsuarioDto usuario, Long idUsuarioIdentidad);

    Mono<Void> habilitar(UsuarioDto usuario);

    Mono<Void> deshabilitar(UsuarioDto usuario, Long idUsuarioIdentidad);

}