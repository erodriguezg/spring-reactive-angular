package com.github.erodriguezg.springreactiveangular.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author eduar
 */
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idPersona;

    private Usuario usuario;

    private Integer run;

    private String nombres;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private Date fechanacimiento;

    private String telefono;

    private String email;

    private Comuna comuna;

    public Persona() {
    }

    public Persona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Long idPersona, String nombres, String apellidoPaterno, String email) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.email = email;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
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

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
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

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(idPersona, persona.idPersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", run=" + run +
                ", nombres='" + nombres + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
