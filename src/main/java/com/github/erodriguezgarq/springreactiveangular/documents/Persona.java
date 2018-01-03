package com.github.erodriguezgarq.springreactiveangular.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

/**
 * @author eduar
 */
@Document(collection = "personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 8360753121986876095L;

    @Id
    private BigInteger id;

    @NotNull
    @Indexed(unique = true)
    @Field("run")
    private Integer run;

    @NotBlank
    @Indexed(unique = true)
    @Field("email")
    private String email;

    @NotBlank
    @Field("nombres")
    private String nombres;

    @NotBlank
    @Field("apellidoPaterno")
    private String apellidoPaterno;

    @NotBlank
    @Field("apellidoMaterno")
    private String apellidoMaterno;

    @Field("fechaNacimiento")
    private Date fechaNacimiento;

    @Field("telefono")
    private String telefono;

    @Field("idComuna")
    private Integer idComuna;

    public Persona() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getRun() {
        return run;
    }

    public void setRun(Integer run) {
        this.run = run;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Integer idComuna) {
        this.idComuna = idComuna;
    }

    @Transient
    public String getNombreCompleto() {
        return nombres + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(run, persona.run);
    }

    @Override
    public int hashCode() {
        return Objects.hash(run);
    }
}
