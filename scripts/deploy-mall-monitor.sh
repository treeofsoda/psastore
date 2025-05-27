#!/bin/bash
docker pull $DOCKER_IMAGE || true
docker rm -f psastorewatch || true
docker run -p 8101:8101 --name psastorewatch \
--link nacos-registry:nacos-registry \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/psastorewatch/logs:/var/logs \
-d $DOCKER_IMAGE
