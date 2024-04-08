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

    stage("Maven Build") {
      steps {
        script {
          sh "mvn clean install" // -T 1C is to make build faster using multithreading
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
                    docker.withRegistry('https://registry.hub.docker.com', 'docker') {
                        docker.image('hello-world').push('latest')
                    }
                }
            }
        }
  }
}
