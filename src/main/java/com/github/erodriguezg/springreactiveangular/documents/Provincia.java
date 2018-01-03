package com.github.erodriguezg.springreactiveangular.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

@Document(collection = "provincias")
public class Provincia implements Serializable {

    private static final long serialVersionUID = 2538028461418905055L;

    @Id
    private BigInteger id;

    @Indexed(unique = true)
    @Field("idProvincia")
    private Integer idProvincia;

    @Field("nombre")
    private String nombre;

    @Field("idRegion")
    private Integer idRegion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
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
        Provincia provincia = (Provincia) o;
        return Objects.equals(idProvincia, provincia.idProvincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProvincia);
    }
}
