![example workflow](https://github.com/DashrathMundkar/cicd-java-maven-project/actions/workflows/maven.yml/badge.svg) ![Jenkins](https://img.shields.io/badge/jenkins-%232C5263.svg?style=for-the-badge&logo=jenkins&logoColor=purple) ![Kubernetes](https://img.shields.io/badge/kubernetes-%23326ce5.svg?style=for-the-badge&logo=kubernetes&logoColor=white) ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) 

# cicd-java-maven-project
This is very basic/simple java-maven project for cicd environment and the purpose of the project is to showcase how to ship application from development to kubernetes environment using CICD.

## Build and deploy locally using docker

1. ```mvn clean install```


3. ```docker build -t hello-world .```


4. ```docker run -d -p 8080:8080 --name hello-world hello-world```


5. Access the application on ```localhost:8080```


## How to deploy on Kubernetes 

1.  First create namesapce by applying yaml file  ```kubectl apply -f kubernetes/namespace.yaml```
3.  Then apply rest of the files from kubernetes folder using ```kubectl apply -f kubernetes/```
4.  Now check if everything is up and running on our namespace using ```kubectl get all -n cicd-java-maven```
5.  And make sure our application pod is up and running ```kubectl get pods -n cicd-java-maven```

### Ok, but how to access the application over browser ????

I assume you have either ```docker dekstop``` or ```kind cluster``` or ```minikube```

1. We need to deploy the ingress-controller for that by applying the yaml file from this official documentation 
 
    ```kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.1.2/deploy/static/provider/cloud/deploy.yaml```
    
2. Check everything is up and running on ```kubectl get all -n ingress-nginx``` if everything is up and running then we are good to go.

3. Now edit your hosts file from this location on Windows ```C:\Windows\System32\drivers\etc\hosts``` and on Mac/Linux ```sudo vim /etc/hosts``` and add the entry in it ```127.0.0.1 exmaple-test.com```

4. Access the application on browser ```exmaple-test.com``` now you should see our awesome project text.


```If you like and want to extend our awesome application then please feel free to contribute :) ```
