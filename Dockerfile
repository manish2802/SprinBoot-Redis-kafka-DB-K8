FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/*.jar SprinBoot-Redis-kafka-DB.jar
                     
EXPOSE 8080

ENTRYPOINT ["java","-jar","SprinBoot-Redis-kafka-DB.jar"]