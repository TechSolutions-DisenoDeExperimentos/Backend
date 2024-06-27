#!/bin/bash

nohup java -jar ./target/TuCine-0.0.1-SNAPSHOT.jar &
FOO_PID=$!
echo "PID: $FOO_PID"
echo $(jobs)