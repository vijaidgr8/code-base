## Mongo website deployment with kubernetes

- create deployment configuraion file
- add mongoDB username password in secrets
- create secret configuration file 
    - kubernetes doesnot take plain text convert plain text into BASE64
        ```
        root = cm9vdA==

        ```
- create sceret from kubectl
```
kubectl apply -f mongo-secret.yml
```
- to watch pod
```
kubectl get pod --watch
```
- to see logs of pod
```
 kubectl describe pod mongodb-deployment-8f6675bc5-xddbx
```
- assign public IP  to service
```
minikube service mongo-express-service
```
- add namspace for service and deployement

```
kubectl apply -f monofo-service.yml --namespace=my-namespace
```
- enable ingress controller
```
minikube addons enable ingress
```
- create dashboard
```
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0/aio/deploy/recommended.yaml
```
- to start proxy server
```
kubectl proxy
```
- add ingress host to etc/hosts
```
windows 10 path 
C:\Windows\System32\drivers\etc\hosts
```
- add ip address and domain for dashboard
```
ip_address dashboard.info
```