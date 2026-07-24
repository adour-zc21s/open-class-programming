pipeline {
    agent any

    tools {
        // Must match the tool name in Manage Jenkins -> Tools
        maven 'Maven-3.9'
        jdk 'JDK-17'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/adour-zc21s/open-class-programming.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Option A: If using system Maven
                // sh 'mvn clean package -DskipTests=false -Dhttp.agent="Mozilla/5.0"'

                // Option B: If using Maven Wrapper (mvnw)
                sh 'chmod +x ./mvnw'
                sh './mvnw clean package -DskipTests=false -Dhttp.agent="Mozilla/5.0"'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying Spring Boot Application...'

                // Option 1: Run locally on the Jenkins server (Background process)
                sh 'nohup java -jar target/*.jar > app.log 2>&1 &'

                // Option 2: Run via Docker (Recommended)
                // sh 'docker build -t spring-boot-app .'
                // sh 'docker run -d -p 8080:8080 --name my-app spring-boot-app'
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed.'
        }
    }
}