pipeline {

  agent any

 environment {
        SONAR_TOKEN = credentials('sonar')
        DOCKERHUB_TOKEN = credentials('docker')   
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
                    docker.build('hello-world')
                }
            }
        }
    stage('Push Docker Image') {
            steps {
                // Push Docker image to Docker Hub repository
                script {
                    docker.withRegistry('https://registry.hub.docker.com', '$DOCKERHUB_TOKEN') {
                        docker.image('hello-world').push('latest')
                    }
                }
            }
        }
  }
}
