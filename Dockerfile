# Use an official Maven image as a builder
FROM maven:3.8.3-openjdk-17

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper files
COPY * .


# Download dependencies and package the application
RUN ./mvnw dependency:go-offline
RUN ./mvnw package -X

# Use a lightweight base image with OpenJDK 17 to run the application
FROM maven:3.8.3-openjdk-17

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the builder stage to the runner stage
COPY --from=builder /app/target/*.jar app.jar

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]
