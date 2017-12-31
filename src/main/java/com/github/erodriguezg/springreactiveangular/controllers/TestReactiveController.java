package com.github.erodriguezg.springreactiveangular.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/test")
public class TestReactiveController {

    @GetMapping("/palabras")
    public Flux<String> palabrasStream() {
        return Flux.fromArray(new String[]{
                "Uno", "Dos", "Tres"
        });
    }

}
