package com.github.erodriguezg.springreactiveangular.config;

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
@EnableReactiveMongoRepositories(basePackages = "com.github.erodriguezg.springreactiveangular.repository")
public class MongoDbConfig {

/*
    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;



    @Value("${spring.data.mongodb.username}")
    private String mongoUsername;

    @Value("${spring.data.mongodb.password}")
    private String mongoPassword;

    */

    @Value("${spring.data.mongodb.database}")
    private String mongoDatabase;

    @Bean
    public Mongobee mongobee(Mongo mongo) {
        Mongobee runner = new Mongobee(mongo);//new Mongobee("mongodb://YOUR_DB_HOST:27017/DB_NAME");
        runner.setDbName(mongoDatabase);         // host must be set if not set in URI
        runner.setChangeLogsScanPackage("com.github.erodriguezg.springreactiveangular.changelog"); // the package to be scanned for changesets
        return runner;
    }


}
