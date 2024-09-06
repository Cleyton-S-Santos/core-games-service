FROM maven:3.9.8-amazoncorretto-21 AS build
WORKDIR /app
COPY . .
ENV PORT=$PORT

RUN mvn clean package -DskipTests

FROM openjdk:21-bullseye
WORKDIR /app

EXPOSE 8080
COPY --from=build /app/target/core-games-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
