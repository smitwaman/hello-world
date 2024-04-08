# Use an official OpenJDK runtime as a base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /

COPY * /
# Copy the application JAR file into the container at /usr/src/app
COPY /target/calculator.jar /

# Expose the port that the application will run on
EXPOSE 8080

# Define the command to run your application when the container starts
CMD ["java", "-jar", "calculator.jar"]
