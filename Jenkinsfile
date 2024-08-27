pipeline {
    agent any

    tools {
        maven 'Maven-3.9.6'
    }

    environment {
        // These can be parameters or credentials
        DB_HOST = 'postgresql.c7ki0kwsskvn.eu-west-1.rds.amazonaws.com'
        DB_PORT = '5432'
        DB_NAME = 'housing'
        DB_USERNAME = 'postgres'
        DB_PASSWORD = 'xebpe1-Paqhoj-jovpir'
    }

    stages {
        stage('Build maven') {
            steps {
                script {
                    // Check out the code from the repository
                    checkout scmGit(branches: [[name: '*/master']],
                                    extensions: [],
                                    userRemoteConfigs: [[url: 'https://github.com/ChrisMuteb/java-jenkins-tutorial-javatechie']])

                    // Run Maven build with environment variables
                    withEnv(["DB_HOST=${env.DB_HOST}", "DB_PORT=${env.DB_PORT}", "DB_NAME=${env.DB_NAME}", "DB_USERNAME=${env.DB_USERNAME}", "DB_PASSWORD=${env.DB_PASSWORD}"]) {
                        sh 'mvn clean install'
                    }
                }
            }
        }
        stage('Build docker image'){
            steps {
                script {
                    // Build Docker image with the necessary environment variables
                    sh 'docker build --build-arg DB_HOST=${DB_HOST} --build-arg DB_PORT=${DB_PORT} --build-arg DB_NAME=${DB_NAME} --build-arg DB_USERNAME=${DB_USERNAME} --build-arg DB_PASSWORD=${DB_PASSWORD} --platform linux/amd64 -t chrismuteb/springboot-jenkins .'
                }
            }
        }
        stage('Push docker image to hub'){
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u chrismuteb -p ${dockerhubpwd}'
                        sh 'docker push chrismuteb/springboot-jenkins'
                    }
                }
            }
        }
    }
}
