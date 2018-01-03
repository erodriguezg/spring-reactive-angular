package com.github.erodriguezgarq.springreactiveangular.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

@Document(collection = "regiones")
public class Region implements Serializable {

    private static final long serialVersionUID = 300006723213976827L;

    @Id
    private BigInteger id;

    @Indexed(unique = true)
    @Field("idRegion")
    private Integer idRegion;

    @Field("nombre")
    private String nombre;

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
        Region region = (Region) o;
        return Objects.equals(idRegion, region.idRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegion);
    }
}
