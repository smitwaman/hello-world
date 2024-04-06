# Use Maven image with JDK 11
FROM maven:3.8.2-jdk-11

# Set working directory inside the container
WORKDIR /

# Copy the Maven project file to the container
COPY * /

# Download all dependencies and build the project
RUN mvn clean package

# Copy the source code 
COPY /target/Task-Management-System.jar /

# Expose
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "Task-Management-System"]

