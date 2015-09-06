#!/bin/bash

for (( i=0; i<10; i++ ))
do
  java -jar jg-cluster-1.0-jar-with-dependencies.jar 2>/dev/null &
done
