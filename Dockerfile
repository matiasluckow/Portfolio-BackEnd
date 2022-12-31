
FROM amazoncorretto:19-alpine-jdk

MAINTAINER emaaristimuno

COPY target/MatiasLuckow-0.0.1-SNAPSHOT.JAR MatiasLuckow-0.0.1-SNAPSHOT.JAR

ENTRYPOINT ["java","-jar","/MatiasLuckow-0.0.1-SNAPSHOT.JAR"]