package com.github.erodriguezg.springreactiveangular.repository;

import com.github.erodriguezg.springreactiveangular.documents.Comuna;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface ComunaRepository extends ReactiveMongoRepository<Comuna, BigInteger> {

    Mono<Comuna> findByIdComuna(Integer idComuna);

    Flux<Comuna> findByIdProvincia(Integer idProvincia);

}
