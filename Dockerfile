FROM ubuntu:latest
LABEL authors="sergio"
# Usa una imagen base con Java 21
FROM eclipse-temurin:21-jdk

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR desde tu máquina al contenedor
COPY build/libs/DrespApiProductos-0.0.1-SNAPSHOT.jar app.jar

# Expón el puerto de tu aplicación Spring Boot
EXPOSE 8080

# Comando que ejecuta tu app
ENTRYPOINT ["java", "-jar", "app.jar"]

