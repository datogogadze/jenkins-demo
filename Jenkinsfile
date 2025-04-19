pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'
        jdk 'jdk21'
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

        stage('Verify') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('My Sonar') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }
}