pipeline {

  agent any

  tools{
    git 'git'
    mvn 'mvn'
  }
  environment {
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


    
  }
}
