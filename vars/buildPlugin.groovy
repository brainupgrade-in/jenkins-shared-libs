def call(Map config) {

    git url: "https://github.com/jenkinsci/${config.name}-plugin.git"
    sh 'mvn -DskipTests clean compile'
}
//Jenkinsfile-scripted buildPlugin name: 'git'