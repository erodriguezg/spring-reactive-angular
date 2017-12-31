package com.github.erodriguezg.springreactiveangular.repository;

import com.github.erodriguezg.springreactiveangular.documents.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, String> {


}