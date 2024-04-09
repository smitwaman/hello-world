pipeline {

  agent any

  environment {
        SONAR_TOKEN = credentials('sonar')
        DOCKERHUB_TOKEN = credentials('dockerhub')
              }

  
  tools {      
    git 'git'
    maven 'maven'
  
        }  
  


  stages {
    stage('Checkout') {
      steps {
            checkout scm // Checkout source code from version control
            }
                      }

    
    stage('Build Docker Image') {
      steps {
       script {
            docker.build('hello-world')
              }
            } 
                              }
     
    stage('Push Docker Image') {
            steps {
                // Push Docker image to Docker Hub repository
                script {
            docker.withRegistry('https://hub.docker.com', '$DOCKERHUB_TOKEN') {
                        
              docker.image('helloworld').push('latest')
                                                                       }
                       }
                  }
                               }
  }
}
