#!/bin/bash
docker pull $DOCKER_IMAGE || true
docker rm -f psastoresearch || true
docker run -p 8081:8081 --name psastoresearch \
--link nacos-registry:nacos-registry \
--link elasticsearch:es \
--link mysql:db \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/psastoresearch/logs:/var/logs \
-d $DOCKER_IMAGE
