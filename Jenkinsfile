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
    
    stage('Workspace Cleaning'){
            steps{
                cleanWs()
            }
        }
    
    stage('Checkout') {
      steps {
            checkout scm // Checkout source code from version control
            }
                      }

    
  

    stage('Build Docker Image') {
      steps {
       script {
            docker.build('helloworld')

          // Tag Docker image
                    docker.image('smitwaman/helloworld').tag('latest')
              }
            } 
          }
   
    
    stage('Push Docker Image') {
            steps {
                // Push Docker image to Docker Hub repository
                script {
                  
                  docker.withRegistry('https://docker.io/smitwaman', 'dockerhub') {
                        docker.image('smitwaman/helloworld').push('latest')
                        }
                     }
                  }
              }
   



    
  }
}
