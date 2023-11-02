FROM openjdk:11
EXPOSE 8089
WORKDIR /app
RUN apt-get update && apt-get install -y curl
RUN curl -o achat-1.0.4.jar -L "http://localhost:8081/repostiroy/maven-snapshots"
ADD target/achat-1.0.4-SNAPSHOT.jar achat-1.0.4-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/achat-1.0.4-SNAPSHOT.jar"]