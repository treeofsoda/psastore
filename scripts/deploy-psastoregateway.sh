#!/bin/bash
docker pull $DOCKER_IMAGE || true
docker rm -f psastoregateway || true
docker run -p 8201:8201 --name psastoregateway \
--link nacos-registry:nacos-registry \
--link mysql:db \
--link redis:redis \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/psastoregateway/logs:/var/logs \
-d $DOCKER_IMAGE
