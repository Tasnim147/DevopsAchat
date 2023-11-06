# Utilisation d'une image de base OpenJDK
FROM openjdk:11-jre-slim
# Exposer le port sur lequel votre application Spring Boot s'exécute (modifier avec le port réel)
EXPOSE 8089
# Définition du répertoire de travail dans le conteneur (chaque commande bch tsir f wost rep hedheka)
WORKDIR /app
# Télécharger le fichier JAR depuis Nexus (a travers l'outil curl) et le copier dans le conteneur
RUN apt-get update && apt-get install -y curl
RUN curl -o achat-1.0.jar -L http://192.168.162.10:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar
#Utilisez un argument de build pour définir le mot de passe pendant la build
ARG DB_PASSWORD
ENV DB_PASSWORD=$DB_PASSWORD
# Définir le point d'entrée de votre application : texecuti jar eli jebtu b java -jar
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
