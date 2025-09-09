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
        always {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts 'target/*.jar'
        }
    }
}

