# Use an OpenJDK image as the base image
FROM openjdk:11-jdk AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Java source files into the container
COPY * /app

# Compile the Java files
RUN mvn build package -DskipTests

# Create a new image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled class files from the builder stage to the current directory in the container
COPY --from=builder /app/target/library.jar ./

# Specify the command to run your application
CMD ["java", "Library"]

