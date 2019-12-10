FROM registry.cn-hangzhou.aliyuncs.com/lm93129/java:8-glibc-pinpoint

MAINTAINER zmk95511@163.com

VOLUME /tmp

EXPOSE 8000

LABEL version="1.0"

COPY docker-entrypoint.sh docker-entrypoint.sh

COPY /target/*.jar /app/app.jar

RUN chmod a+x docker-entrypoint.sh

ENTRYPOINT ["/docker-entrypoint.sh"]

