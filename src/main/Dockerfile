FROM openjdk:11-jdk-alpine
ARG JAR_FILE=build/libs/playlist-0.0.1.jar
COPY ${JAR_FILE} playlist.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/playlist.jar"]
