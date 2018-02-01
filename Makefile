
# settings
ports = -p 8080:8080
volumes = -v jenkins_home:/var/jenkins_home

epoch = $(shell date '+%s')
running_ids = $(shell docker ps -f name=jenkins -q)

build:
	docker build -f DockerFile -t ahammett/jenkins:latest --no-cache .

kill:
	docker stop ${running_ids}
	docker rm ${running_ids}

logs:
	docker logs ${running_ids}

purge:
	docker container prune
	docker image prune
	docker network prune
	docker volume prune

run:
	docker run $(ports) $(volumes) --name jenkins-${epoch} -d ahammett/jenkins:latest

ssh:
	docker exec -it ${running_ids} bash

stop:
	docker stop ${running_ids}

