FROM amazoncorretto:17-alpine-jdk
WORKDIR /home/app
RUN apk add --no-cache wget

COPY build/libs/demo-java-spring-sns-sqs-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java", \
            "-jar", "/home/app/demo-java-spring-sns-sqs-0.0.1-SNAPSHOT.jar"]
