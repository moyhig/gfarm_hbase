#!/usr/bin/env bash

# Please set these variables
export JAVA_HOME=/usr/java/latest
export HADOOP_HOME=/usr/lib/hadoop
export HBASE_HOME=/usr/lib/hbase
export GFARM_HOME=/usr/local/lib
export CPLUS_INCLUDE_PATH=${GFARM_HOME}/../include

# Include jar files
export CLASSPATH=${CLASSPATH}
for f in $HADOOP_HOME/hadoop*core*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done
for f in $HADOOP_HOME/lib/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done
for f in $HADOOP_HOME/lib/jetty-ext/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done

make

cp hadoop-gfarm.jar ${HADOOP_HOME}/lib/
cp libGfarmFSNative.so ${HADOOP_HOME}/lib/native/
cp hadoop-gfarm.jar ${HBASE_HOME}/lib/
cp libGfarmFSNative.so ${HBASE_HOME}/lib/native/Linux-amd64-64/
