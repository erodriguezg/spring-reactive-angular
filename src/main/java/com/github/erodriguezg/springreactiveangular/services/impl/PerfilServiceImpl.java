package com.github.erodriguezg.springreactiveangular.services.impl;

import com.github.erodriguezg.springreactiveangular.services.PerfilService;
import com.github.erodriguezg.springreactiveangular.services.dto.PerfilDto;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class PerfilServiceImpl implements PerfilService {

    @Override
    public List<PerfilDto> traerTodos() {
        return null;
    }

}
