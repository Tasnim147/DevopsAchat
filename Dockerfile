FROM openjdk:11-jre-slim
EXPOSE 8089
WORKDIR /app
RUN apt-get update && apt-get install -y curl
RUN curl -o achat-1.0.jar -L "http://localhost:8081/repostiroy/maven-releases"

ENTRYPOINT ["java","-jar","achat-1.0.jar"]