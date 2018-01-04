package com.github.erodriguezgarq.springreactiveangular.services.impl;

import com.github.erodriguezg.javautils.CodecUtils;
import com.github.erodriguezgarq.springreactiveangular.repository.PerfilRepository;
import com.github.erodriguezgarq.springreactiveangular.repository.PersonaRepository;
import com.github.erodriguezgarq.springreactiveangular.repository.UsuarioRepository;
import com.github.erodriguezgarq.springreactiveangular.services.UsuarioService;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioFiltroDto;
import com.github.erodriguezgarq.springreactiveangular.services.mappers.PerfilMapper;
import com.github.erodriguezgarq.springreactiveangular.services.mappers.PersonaMapper;
import com.github.erodriguezgarq.springreactiveangular.services.mappers.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private CodecUtils codecUtils;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private PerfilMapper perfilMapper;

    @Autowired
    private PersonaMapper personaMapper;

    @Override
    public Mono<UsuarioDto> guardar(UsuarioDto usuarioDto) {
        LOG.debug("Guardar Usuario RUT: ");
        return null;
    }

    @Override
    public Mono<UsuarioDto> traerPorUsernameConPerfilYPersona(String username) {
        return usuarioRepository.findByUsername(username)
                .flatMap(usuario -> Mono.just(usuarioMapper.toUsuarioDto(usuario)))
                .flatMap(usuarioDto -> perfilRepository.findByIdPerfil(usuarioDto.getPerfil().getId())
                        .flatMap(perfil -> {
                            usuarioDto.setPerfil(perfilMapper.toPerfilDto(perfil));
                            return Mono.just(usuarioDto);
                        }))
                .flatMap(usuarioDto -> personaRepository.findByRun(usuarioDto.getPersona().getRun())
                        .flatMap(persona -> {
                            usuarioDto.setPersona(personaMapper.toDto(persona));
                            return Mono.just(usuarioDto);
                        }));
    }

    @Override
    public Flux<UsuarioDto> buscar(UsuarioFiltroDto usuarioFiltroDto) {
        return null;
    }

    @Override
    public Mono<Void> eliminar(UsuarioDto usuarioDto, Long idUsuarioIdentidad) {
        return null;
    }

    @Override
    public Mono<Void> habilitar(UsuarioDto usuarioDto) {
        return Mono.empty();
    }

    @Override
    public Mono<Void> deshabilitar(UsuarioDto usuarioDto, Long idUsuarioIdentidad) {
        return null;
    }

    @Override
    public Mono<UsuarioDto> traerPorRun(Integer run) {
        return null;
    }

}