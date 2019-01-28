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
                sh "docker tag master rfkikt/jenkins-master:${BUILD_NUMBER}"
                sh "docker tag slave  rfkikt/jenkins-slave:${BUILD_NUMBER}"
                withDockerRegistry([credentialsId: 'rfkikt']) {
                    sh "docker push rfkikt/jenkins-master:${BUILD_NUMBER}"
                    sh "docker push rfkikt/jenkins-slave:${BUILD_NUMBER}"
                }
            }
        }

    }
}
