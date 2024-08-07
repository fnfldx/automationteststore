pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    environment {
        MAVEN_OPTS = "-Xms256m -Xmx512m"
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the repository
                git url: 'https://github.com/fnfldx/automationtest.git', branch: 'main'
            }
        }

        stage('Compile') {
            steps {
                // Run Maven clean compile test-compile
                bat 'mvn clean compile test-compile'
            }
        }

        stage('Integration Test') {
            steps {
                // Run Maven failsafe:integration-test
                bat 'mvn failsafe:integration-test'
            }
        }

        stage('Allure Report') {
            steps {
                // Generate Allure report
                bat 'mvn allure:report'
            }
        }
    }

    post {
        always {
            // Archive test results and other artifacts
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
        }

        failure {
            // Notify on failure
            mail to: 'kuba.krzysiek96@gmail.com',
                 subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Something is wrong with ${env.JOB_NAME} - ${env.BUILD_NUMBER}. Please check."
        }
    }
}