pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Deploying....'
            }
        }
        stage('Test') {
            steps {
                sh "mvn clean test -DsuiteXmlFile=tests.xml"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
