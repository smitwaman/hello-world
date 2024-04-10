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

    
    stage("Maven Build") {
      steps {
        script {
          sh "mvn clean package"
        }
      }
    }
    
    
    
    stage('SonarQube Analysis') {
            steps {
                script {
                     withSonarQubeEnv(credentialsId: 'sonar') {
  
                                      sh 'mvn clean verify sonar:sonar \
                                      -Dsonar.projectKey=hello-world \
                                      -Dsonar.host.url=http://localhost:9000 \
                                      -Dsonar.login=$SONAR_TOKEN'
                    }
                 }
              }
           }

    stage('Build Docker Image') {
      steps {
       script {
            docker.build('smitwaman/helloworld')

          // Tag Docker image
                    docker.image('smitwaman/helloworld').tag('latest')
              }
            } 
          }
    stage("TRIVY"){
      steps{
             sh "trivy image smitwaman/helloworld:latest > trivy.txt"
          }  
        } 
   
    
    stage('Push Docker Image') {
            steps {
                // Push Docker image to Docker Hub repository
                script {
                  
                  docker.withRegistry('https://docker.io', 'dockerhub') {
                        docker.image('smitwaman/helloworld').push('latest')
                        }
                     }
                  }
              }
   



    
  }
}
