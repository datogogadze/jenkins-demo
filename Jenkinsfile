pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'
        jdk 'jdk17'
    }

    stages {

        stage('Show Java version') {
            steps {
               sh 'echo JAVA_HOME is $JAVA_HOME'
               sh 'java -version'
            }
        }

        stage('Show Maven version') {
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