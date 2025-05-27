#!/bin/bash
docker pull $DOCKER_IMAGE || true
docker rm -f psastoreweb || true
docker run -p 8085:8085 --name psastoreweb \
--link nacos-registry:nacos-registry \
--link mysql:db \
--link redis:redis \
--link mongo:mongo \
--link rabbitmq:rabbit \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/psastoreweb/logs:/var/logs \
-d $DOCKER_IMAGE
