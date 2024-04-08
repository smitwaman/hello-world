pipeline {

  agent any

 environment {
        SONAR_TOKEN = credentials('sonar')
    }

  
  tools {
    git 'git'
    maven 'maven'
    sonar 'sonar'
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
                     withSonarQubeEnv('SonarQubeServer') {
                        sh 'sonar \
  -Dsonar.projectKey=hello-world \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=$SONAR_TOKEN''
                    }
                }
            }
        }

    
  }
}
