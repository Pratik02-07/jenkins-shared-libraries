def call(String sonarInstallation = 'Sonar', String projectKey, String projectName) {
    stage('SonarQube Analysis') {
        withSonarQubeEnv(sonarInstallation) {
            sh "sonar-scanner -Dsonar.projectKey=${projectKey} -Dsonar.projectName=${projectName}"
        }
    }
}
