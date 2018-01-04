package com.github.erodriguezgarq.springreactiveangular.repository;

import com.github.erodriguezgarq.springreactiveangular.documents.Perfil;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface PerfilRepository extends ReactiveMongoRepository<Perfil, BigInteger> {

    Mono<Perfil> findByIdPerfil(Integer idPerfil);

}
