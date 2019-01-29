pipeline {
    agent { label 'docker' }
    stages {
        stage('Build') {
            steps {
                sh "docker build --tag master master"
                sh "docker build --tag slave slave"
            }
        }
        stage('Publish to Docker Hub') {
            when {
                branch 'master'
            }
            steps {
                sh "docker tag master rogfk/jenkins-master:${BUILD_NUMBER}"
                sh "docker tag slave  rogfk/jenkins-slave:${BUILD_NUMBER}"
                withDockerRegistry([credentialsId: 'rfkikt', url: '']) {
                    sh "docker push rogfk/jenkins-master:${BUILD_NUMBER}"
                    sh "docker push rogfk/jenkins-slave:${BUILD_NUMBER}"
                }
            }
        }

    }
}
