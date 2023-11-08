# Use an OpenJDK base image
FROM openjdk:8
COPY target/achat-1.0.jar .
EXPOSE 8089
ENTRYPOINT ["java","-jar","achat-1.0.jar"]
