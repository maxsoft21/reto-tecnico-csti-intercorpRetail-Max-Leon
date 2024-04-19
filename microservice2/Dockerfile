FROM adoptopenjdk/openjdk17:alpine as builder

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} application.jar

RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk/openjdk17:alpine

COPY --from=builder dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher", "--spring.config.location=file:/data/mcs/reto-tecnico-max-leon-msc2/application-dev.yml"]
