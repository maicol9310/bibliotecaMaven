# Etapa de compilación
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa final (runtime)
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Instalar netcat para usar en wait-for-sqlserver.sh
RUN apt-get update && apt-get install -y netcat-openbsd && rm -rf /var/lib/apt/lists/*

# Copiar jar y script de espera
COPY --from=build /app/target/*.jar app.jar
COPY wait-for-sqlserver.sh .
RUN chmod +x wait-for-sqlserver.sh

EXPOSE 8080

# Esperar a SQL Server antes de arrancar
ENTRYPOINT ["./wait-for-sqlserver.sh", "sqlserver", "1433", "--", "java", "-jar", "app.jar"]
