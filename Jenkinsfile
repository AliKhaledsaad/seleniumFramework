pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build & Test Regression') {
            steps {
                // Run in the workspace root where pom.xml already exists
                bat "mvn clean test -P regression"
            }
        }
    }

   post {
        success {
            slackSend(
                channel: '#demo',
                color: 'good',
                message: "✅ SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' \n" +
                         "URL: ${env.BUILD_URL}"
            )
        }
        failure {
            slackSend(
                channel: '#demo',
                color: 'danger',
                message: "❌ FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' \n" +
                         "URL: ${env.BUILD_URL}"
            )
        }
        unstable {
            slackSend(
                channel: '#demo',
                color: 'warning',
                message: "⚠️ UNSTABLE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' \n" +
                         "URL: ${env.BUILD_URL}"
            )
        }
        always {
            slackSend(
                channel: '#demo',
                color: '#439FE0',
                message: "ℹ️ FINISHED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
            )
        }
    }
}

