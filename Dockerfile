FROM java:8

MAINTAINER shuhao <834122592@qq.com>

VOLUME /tmp

ADD *.jar app.jar

RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]