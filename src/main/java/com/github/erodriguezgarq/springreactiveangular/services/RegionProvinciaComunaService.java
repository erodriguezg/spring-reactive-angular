package com.github.erodriguezgarq.springreactiveangular.services;

import com.github.erodriguezgarq.springreactiveangular.services.dto.ComunaDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.ProvinciaDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.RegionDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RegionProvinciaComunaService {

    Flux<RegionDto> traerRegionasTodas();

    Mono<ComunaDto> traerComunaPorIdComuna(Integer idComuna);

    Flux<ComunaDto> traerComunasPorProvincia(ProvinciaDto provinciaDto);

}
