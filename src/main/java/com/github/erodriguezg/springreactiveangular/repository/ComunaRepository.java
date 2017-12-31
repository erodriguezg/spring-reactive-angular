package com.github.erodriguezg.springreactiveangular.repository;

import com.github.erodriguezg.springreactiveangular.documents.Comuna;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ComunaRepository extends ReactiveMongoRepository<Comuna, Integer> {

    Mono<Comuna> findById(Integer idComuna);

    Flux<Comuna> findComunaByIdProvinciaIs(Integer idProvincia);

}
