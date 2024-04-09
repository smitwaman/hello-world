

# This is simple CICD pipeline for hello-world java application.
- PHASE:1

Tools -
CI- Continuous Integration using jenkins
1. GIT
2. MAVEN
3. SONARQUBE
4. DOCKER
5. DOCKERHUB REGISTRY

Steps we are following:
1. Configure servers for jenkins and sonarqube application.
2. Set ENV VAR for applications as maven, java.   
3. Start, login, configure jenkins and sonarqube.
4. Install all required plugins for project.
5. Add credentials in global list for docker, git, sonar.
6. Write 'dockerfile' and 'jenkinsfile' stages.
7. Run your build  

You can run application after dockerize it:

```
 sudo docker run --name helloworld -p 8086:8080 smiwaman/helloworld:latest
```
- PHASE:2
8. Install trivy and check build image
9. Configure OWAPS  
10. Configure Nexus for artifact management
10. Deploy application using apache server. 

- PHASE:3

Tools -
1. Argo CD
2. Kubernetes

11. Using Argocd, make build and deploy process continuous.

12. Finally configure gmail smtp for email notifications.

- PHASE:4
13. Configure and monitor jenkins server and kubernetes using prometheus and grafana
