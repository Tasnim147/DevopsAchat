FROM openjdk:11
EXPOSE 8081
ADD target/achat-1.0.4-SNAPSHOT.jar achat-1.0.4-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/achat-1.0.4-SNAPSHOT.jar"]