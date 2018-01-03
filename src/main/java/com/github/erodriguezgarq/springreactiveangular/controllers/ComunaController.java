package com.github.erodriguezgarq.springreactiveangular.controllers;

import com.github.erodriguezgarq.springreactiveangular.services.RegionProvinciaComunaService;
import com.github.erodriguezgarq.springreactiveangular.services.dto.ComunaDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.ProvinciaDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/comunas")
public class ComunaController {

    private static final Logger log = LoggerFactory.getLogger(ComunaController.class);

    @Autowired
    private RegionProvinciaComunaService regionProvinciaComunaService;

    @GetMapping("/por-id")
    @PreAuthorize("permitAll()")
    public Mono<ResponseEntity<ComunaDto>> traerComunaPorIdComuna(@RequestParam("idComuna") Integer idComuna) {
        return regionProvinciaComunaService.traerComunaPorIdComuna(idComuna)
                .map(comunaDto -> new ResponseEntity<>(comunaDto, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-idprovincia")
    @PreAuthorize("permitAll()")
    public Flux<ResponseEntity<ComunaDto>> traerComunasPorProvincia(@RequestParam("idprovincia") int idProvincia) {
        return regionProvinciaComunaService.traerComunasPorProvincia(new ProvinciaDto(idProvincia))
                .map(comunaDto -> new ResponseEntity<>(comunaDto, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
