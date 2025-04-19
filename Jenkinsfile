pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'
    }

    stages {

        stage('Verify Maven') {
            steps {
                sh 'mvn -v'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }
}