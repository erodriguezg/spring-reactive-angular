package com.github.erodriguezg.springreactiveangular.services.impl;

import com.github.erodriguezg.springreactiveangular.repository.ComunaRepository;
import com.github.erodriguezg.springreactiveangular.repository.RegionRepository;
import com.github.erodriguezg.springreactiveangular.services.RegionProvinciaComunaService;
import com.github.erodriguezg.springreactiveangular.services.dto.ComunaDto;
import com.github.erodriguezg.springreactiveangular.services.dto.ProvinciaDto;
import com.github.erodriguezg.springreactiveangular.services.dto.RegionDto;
import com.github.erodriguezg.springreactiveangular.services.mappers.ComunaMapper;
import com.github.erodriguezg.springreactiveangular.services.mappers.RegionMapper;
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
        return comunaRepository.findComunaByIdProvinciaIs(provinciaDto.getIdProvincia())
                .flatMap(comuna -> Mono.just(comunaMapper.toDto(comuna)));
    }

}