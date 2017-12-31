package com.github.erodriguezg.springreactiveangular.repository;

import com.github.erodriguezg.springreactiveangular.documents.Region;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RegionRepository extends ReactiveMongoRepository<Region, Integer> {

}
