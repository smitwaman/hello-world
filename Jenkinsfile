pipeline {

  agent any

  environment {
        SONAR_TOKEN = credentials('sonar')
        IMAGE_NAME = 'hello-world'
        DOCKER_REGISTRY = 'https://docker.io'  // Replace with your Docker registry URL
        DOCKER_REPO = 'smitwaman'         // Replace with your repository name
        IMAGE_TAG = 'v1'                   // Replace with the tag you want to use
        DOCKER_IMAGE = "${DOCKER_REPO}/${IMAGE_NAME}:${IMAGE_TAG}"
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


    
   
    stage('OWASP Dependency') {
            steps {
                dependencyCheck additionalArguments: '--scan ./ ', odcInstallation: 'owasp'
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }
     

    


    
  }
}
