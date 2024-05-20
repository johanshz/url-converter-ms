# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Crea un directorio temporal
VOLUME /tmp

# Copia el archivo JAR en el contenedor
COPY build/libs/ms-url-shortener.jar ms-url-shortener.jar

# Establece los permisos para el archivo JAR
RUN chmod 755 ms-url-shortener.jar

# Establece el comando de inicio para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "ms-url-shortener.jar"]
