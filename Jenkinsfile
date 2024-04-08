pipeline {

  agent any

  tools{
    mvn 'mvn'
  }
  environment {
  }


  stages {

    stage("Git Checkout") {
      steps {
        script {
           sh "git scm"
        }
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
