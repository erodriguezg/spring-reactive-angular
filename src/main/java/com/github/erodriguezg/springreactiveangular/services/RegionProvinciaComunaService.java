package com.github.erodriguezg.springreactiveangular.services;

import com.github.erodriguezg.springreactiveangular.services.dto.ComunaDto;
import com.github.erodriguezg.springreactiveangular.services.dto.ProvinciaDto;
import com.github.erodriguezg.springreactiveangular.services.dto.RegionDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RegionProvinciaComunaService {

    Flux<RegionDto> traerRegionasTodas();

    Mono<ComunaDto> traerComunaPorIdComuna(Integer idComuna);

    Flux<ComunaDto> traerComunasPorProvincia(ProvinciaDto provinciaDto);

}
