package com.github.erodriguezgarq.springreactiveangular.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * @author eduar
 */
@Document(collection = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = -696025121548956252L;

    @Id
    private BigInteger id;

    @NotBlank
    @Indexed(unique = true)
    @Field("username")
    private String username;

    @NotBlank
    @Field("password")
    private String password;

    @NotNull
    @Indexed(unique = true)
    @Field("runPersona")
    private Integer runPersona;

    @NotNull
    @Field("idPerfil")
    private Integer idPerfil;

    @NotNull
    @Field("habilitado")
    private Boolean habilitado;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRunPersona() {
        return runPersona;
    }

    public void setRunPersona(Integer runPersona) {
        this.runPersona = runPersona;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(username, usuario.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
