// myPipelineLib.groovy

def call(Map pipelineParams = [:]) {
    def config = [:]
    config.imageAuthor = pipelineParams.imageAuthor ?: 'brainupgrade'
    config.imageName = pipelineParams.imageName ?: 'hello'
    config.imageTag = pipelineParams.imageTag ?: 'tag'
    config.gitRepo = pipelineParams.gitRepo ?: 'https://github.com/brainupgrade-in/gitops-apps-hello.git'
   return this

    // Define the buildJavaApp function
    def buildJavaApp() {
        echo "Building the Java application..."
        sh 'mvn clean install'
    }

    def buildImage(){
        echo "Building docker image"
        sh "docker build -t ${config.imageAuthor}/${config.imageName}:${config.imageTag} ."
    }

    def deployImage(){
        echo "Deploy docker image"
        sh "docker push ${config.imageAuthor}/${config.imageName}:${config.imageTag} "
    }

    // Return the defined functions
    return this
}

