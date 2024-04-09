pipeline {

  agent any

  environment {
        SONAR_TOKEN = credentials('sonar')
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
            docker.build('helloworld')
              }
            } 
                              }
     
    stage('Push Docker Image') {
            steps {
                // Push Docker image to Docker Hub repository
                script {
                  
                  docker.withRegistry('https://docker.io/smitwaman/', 'dockerhub') {
                        
                                               docker.image('helloworld').push('latest')
                                                                       }
                       }
                  }
                               }
  }
}
