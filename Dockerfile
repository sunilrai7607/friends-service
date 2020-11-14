FROM openjdk:8-jdk-alpine
MAINTAINER Sunil Rai <sunilrai7607@gmail.com>
VOLUME /app
ARG version
ENV version_number=$version
COPY ./build/libs/mapstruct-friends-service-$version_number.jar mapstruct-friends-service.jar
ENTRYPOINT ["java", "-jar","/mapstruct-friends-service.jar"]