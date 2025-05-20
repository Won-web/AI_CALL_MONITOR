FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=build/libs/shinhan_auth_api-0.0.1-SNAPSHOT.jar
ENV TZ=Asia/Seoul
COPY ${JAR_FILE} app.jar
EXPOSE 18082
ENTRYPOINT ["java","-jar","/app.jar"]