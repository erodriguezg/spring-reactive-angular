package com.github.erodriguezgarq.springreactiveangular.repository;

import com.github.erodriguezgarq.springreactiveangular.documents.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, BigInteger> {


    Mono<Usuario> findByUsername(String username);

}
