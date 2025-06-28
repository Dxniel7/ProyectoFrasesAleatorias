# Usamos una imagen base de Maven con JDK 21 para compilar el código.
FROM maven:3.9.9-eclipse-temurin-21-alpine as build
WORKDIR /app

# Copia los archivos de configuración para aprovechar el caché de Docker.
COPY pom.xml .
COPY src ./src

# Compila la aplicación, omitiendo las pruebas para un despliegue más rápido.
RUN mvn clean install -DskipTests

# --- ETAPA DE EJECUCIÓN (RUN STAGE) ---
# Usa una imagen de JRE más ligera para ejecutar la aplicación compilada.
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia el archivo JAR compilado desde la etapa de construcción a esta nueva imagen.
COPY --from=build /app/target/FrasesMotivacionales-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usa tu aplicación (8085, según tu application.properties).
EXPOSE 8085

# Define el comando para iniciar la aplicación.
ENTRYPOINT ["java", "-jar", "app.jar"]