# Use an official Maven image as a parent image
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY pom.xml .

# Copy the rest of the project
COPY src ./src

# Build the project using Maven
RUN mvn clean package -X

# Use a lightweight base image with OpenJDK 17 to run the application
FROM adoptopenjdk/openjdk17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the working directory in the container
COPY --from=build /app/target/*.jar ./app.jar

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]

