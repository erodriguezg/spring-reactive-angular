package com.github.erodriguezgarq.springreactiveangular.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

@Document(collection = "comunas")
public class Comuna implements Serializable {

    private static final long serialVersionUID = 5336070918658202149L;

    @Id
    private BigInteger id;

    @Indexed(unique = true)
    @Field("idComuna")
    private Integer idComuna;

    @Field("nombre")
    private String nombre;

    @Field("idProvincia")
    private Integer idProvincia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Integer idComuna) {
        this.idComuna = idComuna;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comuna comuna = (Comuna) o;
        return Objects.equals(idComuna, comuna.idComuna);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComuna);
    }

}
