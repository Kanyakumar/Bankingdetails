FROM openjdk:8-jdk-alpine
ARG JAR_FIFLE=target/*.jar
ADD jpa-docker-1.0.0.jar  /app/app.jar
COPY ${JAR_FIFLE} /app/app.jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","/app/app.jar"]

