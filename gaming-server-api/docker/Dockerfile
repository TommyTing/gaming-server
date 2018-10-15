FROM openjdk:8-jre

MAINTAINER TommyTing 1581447981@qq.com

ENV APP_VERSION 1.0.0-SNAPSHOT
ENV DOCKERIZE_VERSION v0.6.0
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

RUN mkdir /app
WORKDIR /app
COPY gaming-server-api-$APP_VERSION.jar /app/app.jar
ENTRYPOINT ["dockerize", "-timeout", "5m", "-wait", "tcp://172.18.242.163:20881", "-wait","tcp://172.18.242.163:20882", "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar","--spring.profiles.active=dev"]
EXPOSE 8500