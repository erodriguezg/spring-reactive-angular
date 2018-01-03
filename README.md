# spring-reactive-angular
Reactive Stack with Angular View

### Comandos Frontend:
* Instalar Node) mvn frontend:install-node-and-yarn
* Compile Frontend) mvn frontend:yarn -Dfrontend.yarn.arguments="install"
* Run Frontend) mvn frontend:yarn -Dfrontend.yarn.arguments="run start"
* Dist Frontend) mvn frontend:yarn -Dfrontend.yarn.arguments="run build-dev" 

### Comandos Backend:
* Run Backend) spring-boot:run -Duser.language=es -Duser.region=CL -Dfile.encoding=UTF-8
* Limpiar BD) flyway:clean -Dplugin.flyway.url=jdbc:postgresql://localhost:5432/bd -Dplugin.flyway.user=postgres -Dplugin.flyway.password=postgres
* Ejecutar Parches BD) flyway:migrate -Dplugin.flyway.url=jdbc:postgresql://localhost:5432/bd -Dplugin.flyway.user=postgres -Dplugin.flyway.password=postgres

### Spring Data Reference
https://docs.spring.io/spring-data/data-mongodb/docs/2.0.2.RELEASE/reference/html/

### HEADERS 
curl -H "Accept: application/stream+json" 
curl -H "Accept: text/event-stream" (no funciona con MONO, solo FLUX)
