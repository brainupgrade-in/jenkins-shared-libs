#!groovy
/* groovylint-disable MethodReturnTypeRequired, NoDef */
def call(Map config) {
    pipeline {
        agent any
        tools {
            maven 'mvn'
        }
        stages {
            stage('Tools initialization') {
                steps {
                    sh 'mvn --version'
                    sh 'java -version'
                }
            }
            stage('Checkout Code') {
                steps {
                    git branch: "${config.branch}",
                       url: "${config.repoUrl}"
                }
            }
            stage('Cleaning workspace') {
                steps {
                    sh 'mvn clean'
                }
            }
            stage('Running Testcase') {
                steps {
                    sh 'mvn test'
                }
            }
            stage('Packing Application') {
                steps {
                    sh 'mvn package -DskipTests'
                }
            }
        }
    }
}
//Jenkins Controller (import this repo as global lib using Jenkins settings)
//Jenkinsfile
//@Library('brainupgrade-shared-libs') _
//jenkinsForJava (repoUrl: 'https://github.com/brainupgrade-in/spring-framework-petclinic.git', branch: 'main' )

