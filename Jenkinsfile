pipeline {
    agent any

    tools {
        maven 'Maven'   // make sure Maven is configured in Jenkins
        jdk 'JDK17'     // match your Jenkins tool config
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/MayaGadagkar/RestAssuredFramework.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

    }

    post {

        always {
            junit 'target/surefire-reports/*.xml'
        }

    }
}