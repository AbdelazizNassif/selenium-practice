pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "docker -version"
            }
        }
        stage('Test') {
            steps {
                sh "mvn -version"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
