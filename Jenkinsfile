pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'
        jdk 'jdk21'
    }

    stages {

        stage('Show Java & Maven versions') {
            steps {
               sh 'echo JAVA_HOME is $JAVA_HOME'
               sh 'java -version'
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
                script {
                    echo "Analyzing branch: ${env.BRANCH_NAME}"

                    withSonarQubeEnv('My Sonar') {
                        sh """
                            mvn sonar:sonar \
                              -Dsonar.projectKey=jenkins-demo-${env.BRANCH_NAME} \
                              -Dsonar.projectName="Jenkins Demo (${env.BRANCH_NAME})"
                        """
                    }
                }
            }
        }

        stage('SonarQube Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}