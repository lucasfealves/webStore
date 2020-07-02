FROM openjdk:8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/webStore.jar
WORKDIR /app
ENTRYPOINT java -Dspring.profiles.active=docker -jar webStore.jar