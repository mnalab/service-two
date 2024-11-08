# Service-two Dem Project
This is one demo project to create Spring boot demo project and run on docker container

Create K8s objects and deploy on Kubernetes

# Build Image
$ docker build -f container/Dockerfile -t service-two:latest .

# Run container
$ docker run -d -p 9002:9002 --name service-two service-two:latest

$ docker run -d -p 9002:9002 --network bridge \
                        -e SERVICE_ONE_HOST='service-one' \
                          -e SERVICE_ONE_PORT='9001' \
                          --name service-two service-two:latest


# Run Actuator status check
$ curl localhost:8080/actuator/health
