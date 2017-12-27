package com.github.erodriguezg.springreactiveangular.services.impl;

import com.github.erodriguezg.springreactiveangular.dao.PerfilUsuarioDao;
import com.github.erodriguezg.springreactiveangular.services.PerfilService;
import com.github.erodriguezg.springreactiveangular.services.dto.PerfilDto;
import com.github.erodriguezg.springreactiveangular.services.mappers.PerfilUsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilUsuarioDao perfilUsuarioDao;

    @Autowired
    private PerfilUsuarioMapper perfilUsuarioMapper;

    @Transactional(readOnly = true)
    @Override
    public List<PerfilDto> traerTodos() {
        return perfilUsuarioDao.traerTodos().stream()
                .map(perfilUsuarioMapper::toPerfilDto)
                .collect(Collectors.toList());
    }

}
