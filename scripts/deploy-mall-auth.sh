#!/bin/bash
docker pull $DOCKER_IMAGE || true
docker rm -f psastoreaccess || true
docker run -p 8401:8401 --name psastoreaccess \
--link nacos-registry:nacos-registry \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/psastoreaccess/logs:/var/logs \
-d $DOCKER_IMAGE
