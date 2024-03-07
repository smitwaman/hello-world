# Use a Maven image as a base image
FROM maven:3.8.4-openjdk-11 AS builder

# Copy the pom.xml file to the container
COPY * /usr/src/app/

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the rest of the application files to the container


# Build the application with Maven
RUN mvn clean package -DskipTests

# Create a new image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the built JAR file from the builder stage to the current directory in the container
COPY --from=builder /usr/src/app/target/library.jar ./

# Specify the command to run your application
CMD ["java", "-jar", "library.jar"]
