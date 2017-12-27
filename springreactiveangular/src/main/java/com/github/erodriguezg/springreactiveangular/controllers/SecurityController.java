package com.github.erodriguezg.springreactiveangular.controllers;

import com.github.erodriguezg.javautils.CodecUtils;
import com.github.erodriguezg.security.jwt.TokenService;
import com.github.erodriguezg.springreactiveangular.controllers.dto.CredencialesDto;
import com.github.erodriguezg.springreactiveangular.controllers.dto.RespuestaLoginDto;
import com.github.erodriguezg.springreactiveangular.security.SecurityMappings;
import com.github.erodriguezg.springreactiveangular.services.UsuarioService;
import com.github.erodriguezg.springreactiveangular.services.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author eduardo
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

    private static final String ERROR_LOGIN = "Usuario o contraseña incorrecto";

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CodecUtils codecUtils;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SecurityMappings securityMappings;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RespuestaLoginDto login(@RequestBody CredencialesDto credenciales) {
        RespuestaLoginDto respuestaLoginDto = new RespuestaLoginDto();
        Integer rutEntero = Integer.valueOf(credenciales.getRut().trim().split("-")[0].replaceAll("\\.", ""));
        UsuarioDto usuarioDto = this.usuarioService.traerPorRun(rutEntero);
        Optional<String> errorOption = validarCredenciales(credenciales, usuarioDto);
        if (errorOption.isPresent()) {
            respuestaLoginDto.setExitoLogin(false);
            respuestaLoginDto.setErrores(Arrays.asList(new String[]{errorOption.get()}));
        } else {
            respuestaLoginDto.setToken(tokenService.create(securityMappings.userToTokenSubjectMap(usuarioDto)));
            respuestaLoginDto.setExitoLogin(true);
            respuestaLoginDto.setErrores(null);
        }
        return respuestaLoginDto;
    }

    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    public String refreshToken() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return tokenService.create(securityMappings.authToTokenSubjectMap(auth));
    }

    private Optional<String> validarCredenciales(CredencialesDto credenciales, UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            return Optional.of(ERROR_LOGIN);
        }

        String passMD5 = codecUtils.generarHash(CodecUtils.TypeHash.MD5, credenciales.getPassword());
        if (!passMD5.equals(usuarioDto.getPassword())) {
            return Optional.of(ERROR_LOGIN);
        }
        return Optional.empty();
    }

}
