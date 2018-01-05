package com.github.erodriguezgarq.springreactiveangular.repository.template;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import com.github.erodriguezgarq.springreactiveangular.documents.Usuario;
import com.github.erodriguezgarq.springreactiveangular.services.dto.PerfilDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.PersonaDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioFiltroDto;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Repository
public class UsuarioTemplate {


    @Autowired
    private ReactiveMongoTemplate template;


    //https://stackoverflow.com/questions/44949720/spring-mongotemplate-mapping-aggregation-result-to-collections-e-g-list-and
    public Flux<UsuarioDto> buscar(UsuarioFiltroDto filtros) {

        Aggregation agg = newAggregation(
                lookup("personas", " runPersona", " run", "persona"),
                lookup("perfiles", " idPerfil", "idPerfil", "perfil"),
                match(Criteria.where("idPerfil").is(2))
        );

        return template.aggregate(agg, "usuarios", Document.class)
                .flatMap(result -> {
                    return Mono.just(new UsuarioDto());
                });
    }



    /*
    .flatMap(usuarioQuery -> {
                    UsuarioDto usuarioDto = new UsuarioDto();
                    usuarioDto.setUsername(usuarioQuery.getUsername());
                    usuarioDto.setHabilitado(usuarioQuery.isHabilitado());
                    if(usuarioQuery.getPersona() != null && usuarioQuery.getPersona().length > 0) {
                        PersonaQuery personaQuery = usuarioQuery.getPersona()[0];
                        usuarioDto.setPersona(new PersonaDto());
                        usuarioDto.getPersona().setRun(personaQuery.getRun());
                        usuarioDto.getPersona().setEmail(personaQuery.getEmail());
                        usuarioDto.getPersona().setNombres(personaQuery.getNombres());
                        usuarioDto.getPersona().setApPaterno(personaQuery.getApellidoPaterno());
                        usuarioDto.getPersona().setApMaterno(personaQuery.getApellidoMaterno());
                        usuarioDto.getPersona().setFechaNacimiento(personaQuery.getFechaNacimiento());
                    }
                    if(usuarioQuery.getPerfil() != null && usuarioQuery.getPerfil().length > 0 ) {
                        usuarioDto.setPerfil(new PerfilDto());
                        usuarioDto.getPerfil().setId(usuarioQuery.getPerfil()[0].getIdPerfil());
                        usuarioDto.getPerfil().setNombre(usuarioQuery.getPerfil()[0].getNombre());
                    }
                    return Mono.just(usuarioDto);
                });
     */
}
