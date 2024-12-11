# Use a base image with Java 17 / 21
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the jar file to the container
COPY target/departmentAPI-0.0.1-SNAPSHOT.jar departmentAPI.jar

# Run the application
ENTRYPOINT ["java", "-jar", "departmentAPI.jar"]