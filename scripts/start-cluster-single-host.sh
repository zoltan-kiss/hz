#!/bin/bash

for (( i=0; i<10; i++ ))
do
  java -jar -Dlog4j.configuration=log4j.xml ../target/jg-cluster-1.0-jar-with-dependencies.jar &
done
