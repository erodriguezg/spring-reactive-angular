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
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

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
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    public List<UsuarioDto> buscar(@RequestBody UsuarioFiltroDto filtros) {
        log.debug("-> buscar");
        return null;
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public void guardar(@RequestBody @Valid UsuarioDto usuario) {
        log.debug("vacio");
    }

}
