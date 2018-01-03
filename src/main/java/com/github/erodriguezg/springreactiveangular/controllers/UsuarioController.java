package com.github.erodriguezg.springreactiveangular.controllers;

import com.github.erodriguezg.springreactiveangular.services.UsuarioService;
import com.github.erodriguezg.springreactiveangular.services.dto.UsuarioDto;
import com.github.erodriguezg.springreactiveangular.services.dto.UsuarioFiltroDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    public List<UsuarioDto> buscar(@RequestBody UsuarioFiltroDto filtros) {
        log.debug("-> buscar");
        return this.usuarioService.buscar(filtros);
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public void guardar(@RequestBody @Valid UsuarioDto usuario) {
        this.usuarioService.guardarUsuario(usuario);
    }

}
