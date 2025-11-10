# Use an official OpenJDK image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
FROM gradle:8.4-jdk17 AS builder
WORKDIR /app

# Copy everything and build the JAR
COPY . .
RUN gradle build --no-daemon


# Copy the built jar file
COPY build/libs/dailyActivityTrack-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]