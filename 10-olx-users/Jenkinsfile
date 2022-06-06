pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                git 'https://github.com/mohammadazeez963/javaProject.git'
            }
        }
        stage('compile') {
            steps {
                echo 'compiling'
            }
        }
        stage('run') {
            steps {
                echo 'running'
            }
        }
    }
}
