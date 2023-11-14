## Spring Boot, PostgreSQL, Docker, Kubernetes, JPA, Hibernate REST API Demo

## Steps to Setup

**1. Clone the repository**

```bash
git clone https://github.com/yildirim7mustafa/k8s-project.git
```

**2. Deploy PostgreSQL to kubernetes cluster**

Apply your yaml file for database setup

```bash
kubectl create namespace pg-spring #create namespace 

kubectl apply -f deploys/pg-deploy.yaml

kubectl apply -f deploys/pg-pv.yaml

kubectl apply -f deploys/pg-pvc.yaml
	
kubectl apply -f deploys/pg-service.yaml
```

**3. Create Database **

This project uses "market1" database, lets create database.

```bash
kubectl get pods -n pg-spring # check postgre pod name 

kubectl exec -it [pod-name] bash -n pg-spring

psql -U postgres

\l

CREATE DATABASE market1;

\c market1;

\l # you can show market1 database here
```

**4. Clean & Install maven **

![image](https://github.com/yildirim7mustafa/k8s-project/assets/72528911/3f8cdbca-9f80-4a80-94fd-00378f24167b)

**5. build docker file and make a image from jar file then push dockerhub repository **

```bash
docker build -t yildirim7mustafa/deneme .
docker push yildirim7mustafa/deneme # now this image is in internet! 
```
**6. Lets deploy our web project **
```bash
kubectl apply -f deploys/order-svc-deployment.yaml
kubectl apply -f deploys/order-svc-service.yaml
```
**6. Check setup **
```bash
minikube ip
kubectl get service -n pg-spring # take order service port
```
Go browser "http://[minikube-ip]:[order-service-port]/api/v1/customer"

**6. Optional **
if you want add ingress, you need to do this;
- to enable minikube nginx ingress controller
```bash
minikube addons enable ingress
kubectl apply -f deploys/order-ingress.yaml
sudo nano /etc/hosts >> [minikube-ip  sanalmarket.com]
```
Have a nice day
