package com.github.erodriguezgarq.springreactiveangular.repository;

import com.github.erodriguezgarq.springreactiveangular.documents.Region;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.math.BigInteger;

public interface RegionRepository extends ReactiveMongoRepository<Region, BigInteger> {

}
