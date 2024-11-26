FROM maven:3.8.1-openjdk-17-slim AS build

WORKDIR /app

COPY . .

ENV SPRING_PROFILES_ACTIVE=dev

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx2048M", "-jar", "app.jar"]