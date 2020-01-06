FROM registry.cn-hangzhou.aliyuncs.com/lm93129/java:8-glibc-pinpoint

MAINTAINER zmk95511@163.com

VOLUME /tmp

EXPOSE 8000

LABEL version="1.0"

#COPY docker-entrypoint.sh docker-entrypoint.sh
#
#COPY /target/*.jar /app/app.jar
#
#RUN chmod a+x docker-entrypoint.sh
#
#ENTRYPOINT ["/docker-entrypoint.sh"]

ARG JAR_FILE

ADD ${JAR_FILE} app.jar

RUN bash -c 'touch /app.jar'

ENV TZ=Asia/Shanghai

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

CMD ["-jar", "/app.jar"]

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xms256m", "-Xmx512m",  "-XX:PermSize=64m", "-XX:MaxPermSize=128m", "-Xss512k"]