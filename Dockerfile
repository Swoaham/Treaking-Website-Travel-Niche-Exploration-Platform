# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file (we'll build it before deploying)
COPY target/*.jar app.jar

# Expose port (Render uses the PORT env variable)
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
