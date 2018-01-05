package com.github.erodriguezgarq.springreactiveangular.repository.template;

import com.github.erodriguezgarq.springreactiveangular.services.dto.PerfilDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.PersonaDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioDto;
import com.github.erodriguezgarq.springreactiveangular.services.dto.UsuarioFiltroDto;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.lookup;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Repository
public class UsuarioTemplate {


    @Autowired
    private ReactiveMongoTemplate template;


    @SuppressWarnings({"unchecked", "squid:S1192"})
    public Flux<UsuarioDto> buscar(UsuarioFiltroDto filtros) {

        Aggregation agg = newAggregation(
                lookup("personas", "runPersona", "run", "persona"),
                lookup("perfiles", "idPerfil", "idPerfil", "perfil"),
                match(Criteria.where("idPerfil").is(2))
        );

        return template.aggregate(agg, "usuarios", Document.class)
                .flatMap(document -> {
                    UsuarioDto usuarioDto = new UsuarioDto();
                    usuarioDto.setUsername(document.getString("username"));
                    usuarioDto.setPassword(document.getString("password"));
                    usuarioDto.setHabilitado(document.getBoolean("habilitado"));
                    List<Document> personas = document.get("persona", List.class);
                    if (personas != null && !personas.isEmpty()) {
                        Document docPersona = personas.get(0);
                        PersonaDto personaDto = new PersonaDto();
                        personaDto.setRun(docPersona.getInteger("run"));
                        personaDto.setEmail(docPersona.getString("email"));
                        personaDto.setNombres(docPersona.getString("nombres"));
                        personaDto.setApPaterno(docPersona.getString("apellidoPaterno"));
                        personaDto.setApMaterno(docPersona.getString("apellidoMaterno"));
                        personaDto.setFechaNacimiento(docPersona.getDate("fechaNacimiento"));
                        usuarioDto.setPersona(personaDto);
                    }
                    List<Document> perfiles = document.get("perfil", List.class);
                    if (perfiles != null && !perfiles.isEmpty()) {
                        Document docPerfil = perfiles.get(0);
                        PerfilDto perfilDto = new PerfilDto();
                        perfilDto.setId(docPerfil.getInteger("idPerfil"));
                        perfilDto.setNombre(docPerfil.getString("nombre"));
                        usuarioDto.setPerfil(perfilDto);
                    }
                    return Mono.just(usuarioDto);
                });
    }

}
