# Stage 1: Build the application
FROM maven:3.8.3-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Stage 2: Create the final image with the built JAR
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/helloworld-0.0.1-SNAPSHOT.jar ./helloworld.jar
EXPOSE 8080
CMD ["java", "-jar", "helloworld.jar"]
