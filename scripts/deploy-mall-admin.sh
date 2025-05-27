#!/bin/bash
docker pull $DOCKER_IMAGE || true
docker rm -f psastoreadmin || true
docker run -p 8080:8080 --name psastoreadmin \
--link nacos-registry:nacos-registry \
--link mysql:db \
--link redis:redis \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/psastoreadmin/logs:/var/logs \
-d $DOCKER_IMAGE
