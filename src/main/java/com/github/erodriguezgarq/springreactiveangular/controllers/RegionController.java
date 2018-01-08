package com.github.erodriguezgarq.springreactiveangular.controllers;

import com.github.erodriguezgarq.springreactiveangular.services.RegionProvinciaComunaService;
import com.github.erodriguezgarq.springreactiveangular.services.dto.RegionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/regiones")
public class RegionController {

    @Autowired
    private RegionProvinciaComunaService regionProvinciaComunaService;

    @GetMapping("/todas")
    @PreAuthorize("permitAll()")
    public Flux<RegionDto> traerTodas() {
        return regionProvinciaComunaService.traerRegionasTodas();
    }

}
