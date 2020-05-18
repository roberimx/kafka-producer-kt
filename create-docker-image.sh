#!/bin/bash
./gradlew clean build -x test || exit
mkdir -p build/dependency && (
  cd build/dependency || exit
  jar -xf ../libs/*.jar
) || exit
docker build -f Dockerfile -t roberimx/kafka-producer-kt .
docker images roberimx/kafka-producer-kt
