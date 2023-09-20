def call(Map config) {

    git url: "https://github.com/jenkinsci/${config.name}-plugin.git"
    sh 'mvn install'
}
//Jenkinsfile-scripted buildPlugin name: 'git'