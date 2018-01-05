package com.github.erodriguezgarq.springreactiveangular.repository.template;

public class UsuariosQuery {
    private String username;
    private boolean habilitado;
    private PersonaQuery[] persona;
    private PerfilQuery[] perfil;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public PersonaQuery[] getPersona() {
        return persona;
    }

    public void setPersona(PersonaQuery[] persona) {
        this.persona = persona;
    }

    public PerfilQuery[] getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilQuery[] perfil) {
        this.perfil = perfil;
    }
}