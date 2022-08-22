FROM sbtscala/scala-sbt:17.0.2_1.7.1_3.1.3

COPY ./ /app

WORKDIR /app/java
RUN chmod 777 gradlew
RUN ./gradlew build

WORKDIR /app/scala
RUN sbt package

WORKDIR /app/kotlin
RUN chmod 777 gradlew
RUN ./gradlew build

ENTRYPOINT ["java", "-jar","build/libs/kotlin-1.0.0.jar"]