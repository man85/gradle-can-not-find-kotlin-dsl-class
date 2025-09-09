#!/usr/bin/env bash
set -euo pipefail


echo "pwd=$(pwd)"
export GRADLE_USER_HOME="$(pwd)/.gradleHome"
mkdir -p "${GRADLE_USER_HOME}"
config="${GRADLE_USER_HOME}/gradle.properties"

while true; do

    set -x
    gradle --stop
    rm -rf "${GRADLE_USER_HOME}"
    mkdir -p "${GRADLE_USER_HOME}"
    echo "org.gradle.daemon=false" >>"${config}"

    gradle --stacktrace -i :projec-a:check >./build.log
    gradle_code=$?

    set +x
    if [ $gradle_code -ne 0 ]; then
        exit $gradle_code
    fi
done
