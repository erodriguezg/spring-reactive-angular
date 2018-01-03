package com.github.erodriguezgarq.springreactiveangular.changelog;

import com.github.erodriguezgarq.springreactiveangular.utils.FechaUtils;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@ChangeLog(order = "002")
@SuppressWarnings("squid:S1192")
public class V002PerfilesPersonasUsuarios {

    private static final String AUTHOR = "erodriguezg";

    @ChangeSet(order = "01", id = "crearPerfiles", author = AUTHOR)
    public void crearPerfiles(DB db) {
        DBCollection collection = db.createCollection("perfiles", null);
        collection.createIndex(new BasicDBObject("idPerfil", 1), new BasicDBObject("unique", true));
        collection.insert(
                createPerfil(1, "Administrador"),
                createPerfil(2, "Usuario")
        );
    }

    @ChangeSet(order = "02", id = "crearPersonas", author = AUTHOR)
    public void crearPersonas(DB db) {
        DBCollection collection = db.createCollection("personas", null);
        collection.createIndex(new BasicDBObject("run", 1), new BasicDBObject("unique", true));
        collection.createIndex(new BasicDBObject("email", 1), new BasicDBObject("unique", true));
        collection.insert(
                createPersona(11111111, "admin@correo.com", "Admin", "Admin",
                        "Admin", "01/01/1990", "+5691234567", 5801),
                createPersona(22222222, "usuario2@correo.com", "Nombres 2", "Paterno 2",
                        "Materno 2", "01/01/1992", "+5692222222", 5801),
                createPersona(33333333, "usuario3@correo.com", "Nombres 3", "Paterno 3",
                        "Materno 3", "01/01/1993", "+5693333333", 5801),
                createPersona(44444444, "usuario4@correo.com", "Nombres 4", "Paterno 4",
                        "Materno 4", "01/01/1994", "+5694444444", 5801),
                createPersona(55555555, "usuario5@correo.com", "Nombres 5", "Paterno 5",
                        "Materno 5", "01/01/1995", "+5695555555", 5801),
                createPersona(66666666, "usuario6@correo.com", "Nombres 6", "Paterno 6",
                        "Materno 6", "01/01/1996", "+5696666666", 5801),
                createPersona(77777777, "usuario7@correo.com", "Nombres 7", "Paterno 7",
                        "Materno 7", "01/01/1997", "+56977777777", 5801),
                createPersona(88888888, "usuario8@correo.com", "Nombres 8", "Paterno 8",
                        "Materno 8", "01/01/1998", "+56988888888", 5801),
                createPersona(99999999, "usuario9@correo.com", "Nombres 9", "Paterno 9",
                        "Materno 9", "01/01/1999", "+56999999999", 5801)
        );
    }

    @ChangeSet(order = "03", id = "crearUsuarios", author = AUTHOR)
    public void crearUsuarios(DB db) {
        DBCollection collection = db.createCollection("usuarios", null);
        collection.createIndex(new BasicDBObject("username", 1), new BasicDBObject("unique", true));
        collection.createIndex(new BasicDBObject("runPersona", 1), new BasicDBObject("unique", true));
        collection.insert(
                createUsuario(11111111, "admin", "70be2932a9786b17a1351b8d3b9fdf22", 1, true),
                createUsuario(22222222, "user2", "70be2932a9786b17a1351b8d3b9fdf22", 2, true),
                createUsuario(33333333, "user3", "70be2932a9786b17a1351b8d3b9fdf22", 2, true),
                createUsuario(44444444, "user4", "70be2932a9786b17a1351b8d3b9fdf22", 2, true),
                createUsuario(55555555, "user5", "70be2932a9786b17a1351b8d3b9fdf22", 2, true),
                createUsuario(66666666, "user6", "70be2932a9786b17a1351b8d3b9fdf22", 2, true),
                createUsuario(77777777, "user7", "70be2932a9786b17a1351b8d3b9fdf22", 2, true),
                createUsuario(88888888, "user8", "70be2932a9786b17a1351b8d3b9fdf22", 2, true),
                createUsuario(99999999, "user9", "70be2932a9786b17a1351b8d3b9fdf22", 2, true)
        );
    }

    private BasicDBObject createPerfil(Integer idPerfil, String nombre) {
        return new BasicDBObject()
                .append("idPerfil", idPerfil)
                .append("nombre", nombre);
    }

    @SuppressWarnings("squid:S00107")
    private BasicDBObject createPersona(
            Integer run, String email, String nombres,
            String apellidoPaterno, String apellidoMaterno, String fechaNacimieto,
            String telefono, Integer idComuna) {
        return new BasicDBObject()
                .append("run", run)
                .append("email", email)
                .append("nombres", nombres)
                .append("apellidoPaterno", apellidoPaterno)
                .append("apellidoMaterno", apellidoMaterno)
                .append("fechaNacimiento", FechaUtils.parse(fechaNacimieto))
                .append("telefono", telefono)
                .append("idComuna", idComuna);
    }

    private BasicDBObject createUsuario(Integer runPersona, String username, String password, Integer idPerfil, Boolean habilitado) {
        return new BasicDBObject()
                .append("runPersona", runPersona)
                .append("username", username)
                .append("password", password)
                .append("idPerfil", idPerfil)
                .append("habilitado", habilitado);
    }

}
