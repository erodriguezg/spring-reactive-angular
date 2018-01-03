package com.github.erodriguezg.springreactiveangular.repository;

import com.github.erodriguezg.springreactiveangular.documents.Region;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.math.BigInteger;

public interface RegionRepository extends ReactiveMongoRepository<Region, BigInteger> {

}
