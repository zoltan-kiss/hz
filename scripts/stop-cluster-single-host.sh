#!/bin/bash

if `jps | grep jg-cluster >/dev/null 2>&1`
then
  kill `jps | grep jg-cluster | awk '{print $1}'`
fi
