

# This is simple CICD pipeline for hello-world java application.
- PHASE-1:
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
