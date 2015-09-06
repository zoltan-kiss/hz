Imagine an application that is deployed in 10 nodes. A node is a separate JVM process, potentially can be running on different physical machine.

Write an application that will be running on 10 nodes. The application need to coordinate among the nodes and make sure that one and only one of them does a System.out.println("We are started!"). Note: that not all 10 nodes shall start at the same time.

It is possible that some will start couple of seconds/minutes later. Some will not at all. Still I want this message to be printed and only once.


Build the application and lanuch the cluster on single host:
```
mvn clean packe
cd scripts
./start-cluster-single-host.sh
```

Bring down the cluster spun up on single host:
```
./stop-cluster-single-host.sh
```
