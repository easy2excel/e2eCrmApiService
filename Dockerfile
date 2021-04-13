FROM openjdk:8-jdk-alpine
MAINTAINER easy2excel.in
WORKDIR /app
ARG JAR_FILE=serviceLayer/target/serviceLayer-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} e2ecrmservice.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/e2ecrmservice.jar"]