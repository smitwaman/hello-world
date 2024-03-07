# Use Maven image with JDK 11
FROM maven:3.8.2-jdk-11

# Set working directory inside the container
WORKDIR /usr/src/library

# Copy the Maven project file to the container
COPY pom.xml .

# Download all dependencies and build the project
RUN mvn dependency:go-offline

# Copy the source code to the container
COPY src ./src

# Build the project
RUN mvn package

# Define the command to run the application
CMD ["java", "-cp", "target/library.jar", "Library"]

