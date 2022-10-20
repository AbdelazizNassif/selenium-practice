pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                docker compose -f src/test/resources/docker-compose-file.yml up --scale chrome=5 -d
            }
        }
        stage('Test') {
            steps {
                mvn clean test -DsuiteXmlFile=tests.xml
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
