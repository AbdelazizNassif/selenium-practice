pipeline {
    agent any
  tools {
    maven 'maven-3.6.3' 
  }
    stages {
        stage ('Initialize') {
            steps {
                sh 'mvn -version' 
            }
        }

        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
                
            }
        }
    }
}
