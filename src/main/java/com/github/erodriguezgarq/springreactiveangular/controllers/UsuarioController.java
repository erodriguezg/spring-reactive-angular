package com.github.erodriguezgarq.springreactiveangular.controllers;

import com.github.erodriguezgarq.springreactiveangular.services.UsuarioService;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioFiltroDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
    public Mono<ResponseEntity<UsuarioDto>> traerPorId(@PathVariable("username") String username) {
        return usuarioService.traerPorUsernameConPerfilYPersona(username)
                .map(usuarioDto -> new ResponseEntity<>(usuarioDto, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PostMapping("/buscar")
    public Flux<ResponseEntity<UsuarioDto>> buscar(@RequestBody UsuarioFiltroDto filtros) {
        log.debug("-> buscando usuarios por filtros: {}", filtros);
        return usuarioService.buscar(filtros)
                .map(usuarioDto -> new ResponseEntity<>(usuarioDto, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public Mono<ResponseEntity<Void>> guardar(@RequestBody @Valid UsuarioDto usuario) {
        log.debug("vacio");
        return Mono.just(ResponseEntity.ok().<Void>build())
                .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).<Void>build());
    }

}
