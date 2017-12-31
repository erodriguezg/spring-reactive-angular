package com.github.erodriguezg.springreactiveangular.controllers;

import com.github.erodriguezg.springreactiveangular.services.RegionProvinciaComunaService;
import com.github.erodriguezg.springreactiveangular.services.dto.ComunaDto;
import com.github.erodriguezg.springreactiveangular.services.dto.ProvinciaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/comunas")
public class ComunaController {

    @Autowired
    private RegionProvinciaComunaService regionProvinciaComunaService;

    @GetMapping("/por-idprovincia")
    @PreAuthorize("permitAll()")
    public Flux<ResponseEntity<ComunaDto>> traerComunasPorProvincia(@RequestParam("idprovincia") int idProvincia) {
        return regionProvinciaComunaService.traerComunasPorProvincia(new ProvinciaDto(idProvincia))
                .map(comunaDto -> new ResponseEntity<>(comunaDto, HttpStatus.OK));
    }

}
