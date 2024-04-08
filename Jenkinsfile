pipeline {

  agent any

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
                    // Execute SonarQube scan
                    withSonarQubeEnv('SonarQubeServer') {
                        sh 'mvn clean verify sonar:sonar \
  -Dsonar.projectKey=hello-world \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=e3643a1be09e722440027d395c63a45eb4cdf99e'
                    }
                }
            }
        }

    
  }
}
