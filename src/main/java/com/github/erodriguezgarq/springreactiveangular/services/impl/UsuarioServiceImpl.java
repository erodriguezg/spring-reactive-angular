package com.github.erodriguezgarq.springreactiveangular.services.impl;

import com.github.erodriguezg.javautils.CodecUtils;
import com.github.erodriguezgarq.springreactiveangular.services.UsuarioService;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioFiltroDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private CodecUtils codecUtils;

    @Override
    public List<UsuarioDto> traerTodos() {
        return null;
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto) {
        LOG.debug("Guardar Usuario RUT: " + usuarioDto.getRut());
        return null;
    }

    @Override
    public UsuarioDto traerPorUsername(String username) {
        return null;
    }

    @Override
    public List<UsuarioDto> buscar(UsuarioFiltroDto usuarioFiltroDto) {
        return null;
    }

    @Override
    public void eliminar(UsuarioDto usuarioDto, Long idUsuarioActual) {

    }

    @Override
    public void habilitar(UsuarioDto usuarioDto) {
        return;
    }

    @Override
    public void deshabilitar(UsuarioDto usuarioDto, Long idUsuarioActual) {
        return;
    }

    @Override
    public UsuarioDto traerPorRun(Integer run) {
        return null;
    }

}