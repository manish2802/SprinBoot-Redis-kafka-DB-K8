FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/SprinBoot-Redis-kafka-DB-0.0.1-SNAPSHOT.jar SprinBoot-Redis-kafka-DB.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","SprinBoot-Redis-kafka-DB.jar"]