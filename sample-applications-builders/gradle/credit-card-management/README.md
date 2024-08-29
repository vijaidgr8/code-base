# CreditCardBillPayment




**1) Deployement using docker and docker composefile**

**Install Docker

sudo yum update -y;sudo yum install docker -y;sudo systemctl start docker;sudo usermod -a -G docker ec2-user;sudo systemctl enable docker;sudo systemctl status docker

**Install git**

sudo yum install git

sudo git clone https://github.com/neeli-kavitha/CreditCardBillPayment.git

ls

cd CreditCardBillPayment

ls

sudo docker build -t app .

sudo docker image ls

sudo wget https://github.com/docker/compose/releases/download/v2.5.0/docker-compose-linux-x86_        64

sudo chmod +x docker-compose-linux-x86_64

sudo mv docker-compose-linux-x86_64 docker-compose

sudo mv docker-compose /usr/local/bin/docker-compose

docker compose --version

docker ps


sudo su –

cd /home/ec2-user/

cd CreditCardBillPayment

ls -lrt

docker-compose up -d

docker-compose ps

**For database**
docker container exec -it 79 bash

psql -h localhost -p 5432 -U scott -W

\l

\c postgres

\dt

==  79 container starting number

== scott username




**###########################################################################################################################################################***



**2) Deployment using kubernates**


sudo yum update -y;sudo yum install docker -y;sudo systemctl start docker;sudo usermod -a -G docker ec2-user;sudo systemctl enable docker;sudo systemctl status docker

curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"

sudo chmod +x kubectl

sudo mv kubectl /usr/bin/
 
sudo su -

curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64

sudo install minikube-linux-amd64 /usr/local/bin/minikube
 
yum install conntrack -y

minikube start --vm-driver=none

yum install git

git clone https://github.com/neeli-kavitha/CreditCardBillPayment.git

ls

cd CreditCardBillPayment/

ls

cd config/

kubectl apply -f db_deployment.yml

kubectl apply -f service_db.yml

kubectl get svc

vi app_deployment.yml

kubectl apply -f app_deployment.yml

kubectl apply -f service_app.yml

kubectl get svc 

kubectl get all

**For database**

kubectl exec -it creditcardbillpayment-88b7cf487-v2m9t – bash

psql -U kavitha -d postgres

\dt


