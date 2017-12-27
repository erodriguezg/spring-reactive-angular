package com.github.erodriguezg.springreactiveangular.managedbeans;

import com.github.erodriguezg.springreactiveangular.services.PerfilService;
import com.github.erodriguezg.springreactiveangular.services.dto.PerfilDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author takeda
 */
@Component
@Scope("request")
public class PerfilBean {

    @Autowired
    private PerfilService perfilService;

    public List<PerfilDto> getTraerTodos() {
        return this.perfilService.traerTodos();
    }

}
