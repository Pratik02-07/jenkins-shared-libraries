def call(String project, String imageTag, String dockerHubUser) {
    // 1. Rename the variable inside usernameVariable to avoid naming conflicts
    withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerHubPass', usernameVariable: 'credentialUser')]) {
        sh "docker login -u ${credentialUser} -p ${dockerHubPass}"
    }
    sh "docker push ${dockerHubUser}/${project}:${imageTag}"
  }
