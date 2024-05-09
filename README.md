# Introduccion

Este componente esta desarrollado con una arquitectura por capas 

Capa de Datos
Capa de Servicio
Capa de presentacion
Capa de aspectos

Abrir el proyecto en Intellij IDEA agregando el plugin de springboot y gradle para levantar en un entorno local.

# Entorno de desarrollo 
* Java 17 OPEN JDK
* Springboot
* Gradle - Instalacion Gradle https://gradle.org/install/
* IDE Jetbrains Intellij 
* OpenApi

# Compilación
gradle clean 
gradle build

# JAR
 java -jar  ..build/libs/proa-crud-session-0.0.1-SNAPSHOT.jar

# Open API

Despues de levantar el proyecto se podra apreciar la documentacion

[http://localhost:8080/swagger-ui/index.html#/]()

# Endpoints

METHOD = POST
* Alta producto: [localhost:8080/productos]()

METHOD = PUT
* Actualiza producto: [localhost:8080/productos]()

METHOD = GET
* Lista productos: [localhost:8080/productos/listado]()

METHOD = GET
* Obtener producto: [localhost:8080/productos/id/f18e4013-43a3-45ff-b504-680ca0971ad4/producto]()
* Agregar en la cabecera de postman el id de cliente para su validacion.
* Se penso enla consulta por id de producto ya que por la marca podria ser muy ambiguo.
