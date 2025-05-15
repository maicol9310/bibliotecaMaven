#!/bin/bash
set -e

echo "⏳ Esperando a SQL Server en sqlserver:1433..."

# Esperar hasta que el puerto 1433 esté disponible en el contenedor de SQL Server
while ! nc -z sqlserver 1433; do
  sleep 1
done

echo "✅ SQL Server disponible. Iniciando aplicación..."

exec java -jar app.jar
