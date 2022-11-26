FROM openjdk:17-alpine
EXPOSE 8080
ARG JAR_FILE=build/libs/simple-docker-app-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
