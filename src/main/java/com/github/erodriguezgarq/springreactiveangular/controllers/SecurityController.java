package com.github.erodriguezgarq.springreactiveangular.controllers;

import com.github.erodriguezg.javautils.CodecUtils;
import com.github.erodriguezg.security.jwt.TokenService;
import com.github.erodriguezgarq.springreactiveangular.controllers.dto.CredencialesDto;
import com.github.erodriguezgarq.springreactiveangular.controllers.dto.RefreshTokenDto;
import com.github.erodriguezgarq.springreactiveangular.controllers.dto.RespuestaLoginDto;
import com.github.erodriguezgarq.springreactiveangular.security.SecurityMappings;
import com.github.erodriguezgarq.springreactiveangular.services.UsuarioService;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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

    @PostMapping("/login")
    public Mono<ResponseEntity<RespuestaLoginDto>> login(@RequestBody CredencialesDto credenciales) {
        return this.usuarioService.traerPorUsernameConPerfilYPersona(credenciales.getUsername())
                .flatMap(usuarioDto -> {
                    RespuestaLoginDto respuestaLoginDto = new RespuestaLoginDto();
                    Optional<String> errorOption = validarCredenciales(credenciales, usuarioDto);
                    if (errorOption.isPresent()) {
                        respuestaLoginDto.setExitoLogin(false);
                        respuestaLoginDto.setErrores(Arrays.asList(new String[]{errorOption.get()}));
                    } else {
                        respuestaLoginDto.setToken(tokenService.create(securityMappings.userToTokenSubjectMap(usuarioDto)));
                        respuestaLoginDto.setExitoLogin(true);
                        respuestaLoginDto.setErrores(null);
                    }
                    return Mono.just(new ResponseEntity<>(respuestaLoginDto, HttpStatus.OK));
                })
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PostMapping("/refreshToken")
    public Mono<ResponseEntity<RefreshTokenDto>> refreshToken() {
        return Mono.just(SecurityContextHolder.getContext().getAuthentication())
                .flatMap(auth -> {
                    String token = tokenService.create(securityMappings.authToTokenSubjectMap(auth));
                    RefreshTokenDto refreshTokenDto = new RefreshTokenDto();
                    refreshTokenDto.setToken(token);
                    return Mono.just(new ResponseEntity<>(refreshTokenDto, HttpStatus.OK));
                })
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
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
