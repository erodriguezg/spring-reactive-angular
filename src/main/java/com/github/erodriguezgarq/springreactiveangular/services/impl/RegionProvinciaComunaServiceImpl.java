package com.github.erodriguezgarq.springreactiveangular.services.impl;

import com.github.erodriguezgarq.springreactiveangular.repository.ComunaRepository;
import com.github.erodriguezgarq.springreactiveangular.repository.RegionRepository;
import com.github.erodriguezgarq.springreactiveangular.services.RegionProvinciaComunaService;
import com.github.erodriguezgarq.springreactiveangular.services.dto.ComunaDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.ProvinciaDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.RegionDto;
import com.github.erodriguezgarq.springreactiveangular.services.mappers.ComunaMapper;
import com.github.erodriguezgarq.springreactiveangular.services.mappers.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class RegionProvinciaComunaServiceImpl implements RegionProvinciaComunaService {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private ComunaRepository comunaRepository;

    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private ComunaMapper comunaMapper;

    @Override
    public Flux<RegionDto> traerRegionasTodas() {
        return regionRepository.findAll()
                .flatMap(region -> Mono.just(regionMapper.toDto(region)));
    }

    @Override
    public Flux<ComunaDto> traerComunasPorProvincia(ProvinciaDto provinciaDto) {
        return comunaRepository.findByIdProvincia(provinciaDto.getIdProvincia())
                .flatMap(comuna -> Mono.just(comunaMapper.toDto(comuna)));
    }

    @Override
    public Mono<ComunaDto> traerComunaPorIdComuna(Integer idComuna) {
        return comunaRepository.findByIdComuna(idComuna)
                .flatMap(comuna -> Mono.just(comunaMapper.toDto(comuna)));
    }

}
