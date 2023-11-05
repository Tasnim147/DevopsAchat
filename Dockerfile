FROM openjdk:11-jre-slim

# Install curl
RUN apt-get update && apt-get install -y curl

# Set the working directory
WORKDIR /app

# Download the JAR file from your repository
RUN curl -o achat-1.0.jar -L "http://192.168.206.222:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar" && \
    chmod +x achat-1.0.jar

# Expose the application's port
EXPOSE 8089

# Define the entry point
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
