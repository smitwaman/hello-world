# This is simple CICD pipeline for hello-world java application.
- PHASE:1

Tools -
CI- Continuous Integration using jenkins
1. GIT
2. MAVEN
3. SONARQUBE
4. DOCKER
5. DOCKERHUB REGISTRY
6. Trivy

Steps we are following:
1. Configure servers for jenkins and sonarqube application.
2. Set ENV VAR for applications as maven, java.   
3. Start, login, configure jenkins and sonarqube.
4. Install all required plugins for project.
5. Add credentials in global list for docker, git, sonar.
6. Write 'dockerfile' and 'jenkinsfile' stages.
7. Run your build
8. Check vernability with trivy.

You can run application after dockerize it:

```
 sudo docker run --name helloworld -p 8086:8080 smiwaman/helloworld:latest
```



![Jenkins Output:](https://github.com/smitwaman/hello-world/blob/main/Images/Screenshot%202024-04-11%20094522.png)

![SonarQube Output:](https://github.com/smitwaman/hello-world/blob/main/Images/Screenshot%202024-04-10%20064735.png)

![Docker-Browser Output:](https://github.com/smitwaman/hello-world/blob/main/Images/Screenshot%202024-04-11%20095041.png)

- PHASE:2
10. Configure Nexus for artifact management(Optional)
Here,You can copy artifact from maven build stage.
11. And deploy application using apache, nginx server. 

for deploying jar artifact we have to write copy artifact stage to apache staging file with symlink.
Before that we need to login apache using ssh key.
```
 stage('Copy Artifact') {
   steps {
// Copy the JAR artifact to Apache's DocumentRoot
sh 'scp -i ${ssh_key} hello-world.jar sparx@apache-server:/var/www/staging/'
            }
        }
    }
```
Define env var  ${ssh_key} in env
- PHASE:3

Tools -
1. Argo CD
2. Kubernetes

11. Using Argocd, make build and deploy process continuous.

12. Finally configure gmail smtp for email notifications.

- PHASE:4
13. Configure and monitor jenkins server and kubernetes using prometheus and grafana

![](https://github.com/smitwaman/hello-world/blob/main/Images/Screenshot%202024-04-12%20125242.png)


