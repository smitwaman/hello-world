# Use an official OpenJDK runtime as a base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the compiled Java application JAR file into the container at /usr/src/app
COPY * /usr/src/app

RUN mvn clean build 


# Specify the command to run your application
CMD ["java", "-jar", "library.jar"]
