pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/AliKhaledsaad/seleniumFramework.git'
            }
        }

        stage('Test with Regression Profile') {
            steps {
               dir('seleniumFramework') {   // path where pom.xml lives
                bat "mvn test -Pregression"
                }
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

