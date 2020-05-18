FROM openjdk:8-jre-alpine
RUN addgroup -S spring && adduser -S spring -G spring
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
USER spring:spring
ENTRYPOINT ["java","-cp","app:app/lib/*","me.tecuani.kafkaproducer.KafkaProducerApplicationKt"]
