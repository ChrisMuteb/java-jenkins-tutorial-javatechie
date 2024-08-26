pipeline {
    agent any

    tools {
        maven 'Maven-3.9.6'
    }

    stages {


        stage('Build maven') {
            steps {
                // Build the Docker image, passing the environment variable
                script {
                    // def dockerImage = docker.build("your-image-name:${env.BUILD_ID}", "--build-arg DB_HOST=${DB_HOST} .")
                    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ChrisMuteb/java-jenkins-tutorial-javatechie']])
                    sh 'mvn clean install'
                }
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t chrismuteb/devops-integration .'
                }
            }
        }
        stage('Push docker image to hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u chrismuteb -p ${dockerhubpwd}'
}
                    sh 'docker push chrismuteb/devops-integration'
                }
            }
        }
    }
}
