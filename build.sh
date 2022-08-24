cd java
./gradlew build
cd ..
cd scala
sbt package
cd ..
cp ./js/* ./kotlin/src/main/resources/static
cd kotlin
./gradlew build
java -jar build/libs/kotlin-1.0.0.jar -Xmx512m
rm ./src/main/resources/static/*.js
rm ./src/main/resources/static/*.html
rm ./src/main/resources/static/*.css