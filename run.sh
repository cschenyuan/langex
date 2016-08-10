#!/bin/bash

PROJECT=book.jvm
REBUILD=0
case "$1" in
    --build|-b)
        REBUILD=1
        shift;
        ;;
    -p)
        PROJECT="$1"
        shift;
        ;;
esac

# build
if [ $REBUILD == 1 ];then
    mvn clean compile -DskipTests
fi

echo -e "\n-----------------"
#java -cp ./target/classes/ com.atella.java.concurrent."$1"
# programma
#java -cp ./target/classes/ com.atella.java.programma."$1"

. ./vm_options
echo "VM OPTS: $OPTS"
# test
java $OPTS -cp ./target/classes/ com.atella.$PROJECT."$1"
