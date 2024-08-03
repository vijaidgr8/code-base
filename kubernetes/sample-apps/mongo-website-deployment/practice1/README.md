## Kubectl commands
- get status of nodes
    ```
    kubctl get nodes
    ```
- get pods
    ```
    kubctl get pod
    ```
- services
    ```
    kubectl get services
    ```
- create deployment
    ```
    kubectl create deployment ngnix-depl --image=nginx
    ```
- check deployment
  ```
  kubectl get deployment
  ```
- get replicasets
    ```
    kubectl get replicaset
    ```
- simple nginx configuration file
  
    ```
    apiVersion: apps/v1
    kind: Deployment
    metadata:
    name: nginx-deployment
    labels:
        app: nginx
    spec:
    replicas: 2
    selector:
        matchLabels:
        app: nginx
    template:
        metadata:
        labels:
            app: nginx
        spec:
        containers:
        - name: nginx
            image: nginx:1.16
            ports:
            - containerPort: 8080
    ```
- create deployment with deployment configuration file
    ```
    kubectl apply -f nginxdeployment.yml
    ```
- create service for deployemnt
    ```
    apiVersion: v1
    kind: Service
    metadata:
    name: nginx-service
    spec:
    selector:
        app: nginx
    ports:
        - protocol: TCP
        port: 80
        targetPort: 8080

    ```
- apply service
    ```
    kubectl apply -f ngnixservice.yml
    ```
- validate the service has right pods
    ```
    kubectl describe service nginx-service
    ```
- get more information about pods
    ```
    kubectl get pod -o wide
    ```
- get status of deployment in yaml file 
    ```
    kubectl get deployment -o yml > nginx-deploy-result.yml
    ```
- delete deployment and service
    ```
    kubectl delete -f nginxdeployment.yml
    kubectl delete -f nginxservice.yml
    ```


