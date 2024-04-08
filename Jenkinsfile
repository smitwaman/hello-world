pipeline {

  agent any

 

  
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
  
sh 'sonar \
  -Dsonar.projectKey=hello-world \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=83a3820a62d222a687fa487a6cc6a7c1b2196af8'
                    }
                }
            }
        }

    
  }
}
