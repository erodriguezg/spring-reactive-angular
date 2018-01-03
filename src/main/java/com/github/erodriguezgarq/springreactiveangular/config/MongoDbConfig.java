package com.github.erodriguezgarq.springreactiveangular.config;

import com.github.mongobee.Mongobee;
import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Created by eduar on 14/05/2017.
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.github.erodriguezgarq.springreactiveangular.repository")
public class MongoDbConfig {

    @Value("${spring.data.mongodb.database}")
    private String mongoDatabase;

    @Bean
    public Mongobee mongobee(Mongo mongo) {
        Mongobee runner = new Mongobee(mongo);
        runner.setDbName(mongoDatabase);
        runner.setChangeLogsScanPackage("com.github.erodriguezgarq.springreactiveangular.changelog");
        return runner;
    }

}
