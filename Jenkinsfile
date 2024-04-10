pipeline {

  agent any

  environment {
        SONAR_TOKEN = credentials('sonar')

        DOCKER_REGISTRY = 'docker.io'  // Replace with your Docker registry URL
        DOCKER_REPO = 'smitwaman'         // Replace with your repository name
        DOCKER_TAG = 'latest'                   // Replace with the tag you want to use
        DOCKER_IMAGE = "${DOCKER_REGISTRY}/${DOCKER_REPO}:${DOCKER_TAG}"
    }
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
                // Build your Docker image here if it's not already built
                sh 'docker build -t ${DOCKER_IMAGE} .'
            }
        }

        stage('Push Docker Image') {
            steps {
                // Login to Docker Hub using credentials
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
                }

                // Push the Docker image to Docker Hub
                sh "docker push ${DOCKER_REPO}:${DOCKER_TAG}"
            }
        }
    }

    post {
        always {
            // Logout from Docker Hub after pushing the image
            sh 'docker logout'
        }
  

    


    
  }
}
