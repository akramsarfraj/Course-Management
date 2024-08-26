FROM openjdk:17

COPY target/CoursesApi-0.0.1-SNAPSHOT.jar  CoursesApi.jar

ENTRYPOINT ["java" ,"-jar","CoursesApi.jar"]