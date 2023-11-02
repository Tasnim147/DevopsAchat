FROM openjdk:11
EXPOSE 8081
ADD target/achat-1.0.3-SNAPSHOT.jar achat-1.0.3-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/achat-1.0.2-SNAPSHOT.jar"]