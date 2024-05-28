FROM openjdk:17-jdk-alpine
WORKDIR /java/app
COPY target/pkbackend-0.0.1-SNAPSHOT.jar app.jar
# EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]


# pull mysql
#docker pull mysql:5.7
# create a docker network through which the database and backend will communicate
#docker network create <name of the network>
# docker network ls
#Run the mysql container in the network
# docker run --name portkeeperdatabase --network portkeepernetwork -e MYSQL_ROOT_PASSWORD=0987 -e MYSQL_DATABASE=database -e MYSQL_USER=bakare -e MYSQL_PASSWORD=0987 -d mysql:5.7
# docker build . -t "portkeeperbackend:v1.0"
#update the properties files
#build the java docker image
# docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 portkeeper
# docker run -p 8080:8080 portkeeper java -jar /app/portkeeper.jar --spring.profiles.active=prod


#run the spring boot container on the same network
# docker run --network portkeepernetwork --name portkeepercontainer -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=prod" -d portkeeperbackend