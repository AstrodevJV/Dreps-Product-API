# Etapa 1: build
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

COPY . .
RUN ./gradlew clean build -x test

# Etapa 2: run
FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
