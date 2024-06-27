#!/bin/bash

java -jar ./target/TuCine-0.0.1-SNAPSHOT.jar &>/tmp/output.log &
FOO_PID=$!
echo "PID: $FOO_PID"
echo $(jobs)