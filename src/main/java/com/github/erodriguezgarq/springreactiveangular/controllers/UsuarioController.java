package com.github.erodriguezgarq.springreactiveangular.controllers;

import com.github.erodriguezgarq.springreactiveangular.services.UsuarioService;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioFiltroDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author eduardo
 */
@RestController
@Scope("request")
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/username/{username}")
    public Mono<UsuarioDto> traerPorId(@PathVariable("username") String username) {
        return usuarioService.traerPorUsernameConPerfilYPersona(username);
    }

    @PostMapping("/buscar")
    @PreAuthorize("isAuthenticated()")
    public Flux<UsuarioDto> buscar(@RequestBody UsuarioFiltroDto filtros, @AuthenticationPrincipal UsuarioDto principal) {
        log.debug("-> buscando usuarios por filtros: {}", filtros);
        log.debug("-> principal: {}", principal);
        return usuarioService.buscar(filtros);
    }

    @GetMapping("/buscar-test")
    @PreAuthorize("permitAll()")
    public Flux<UsuarioDto> buscar() {
        UsuarioFiltroDto filtros = new UsuarioFiltroDto();
        log.debug("-> buscando usuarios por filtros: {}", filtros);
        return usuarioService.buscar(filtros);
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public Mono<Void> guardar(@RequestBody @Valid UsuarioDto usuario) {
        log.debug("vacio");
        return Mono.empty();
    }

}
