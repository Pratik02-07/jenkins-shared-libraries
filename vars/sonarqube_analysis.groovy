def call(String sonarInstallation = 'SonarQube') {
    stage('SonarQube Analysis') {
        // Wraps the scanner execution with the server environment configuration
        withSonarQubeEnv(sonarInstallation) {
            if (fileExists('pom.xml')) {
                sh 'mvn clean verify sonar:sonar'
            } else if (fileExists('package.json')) {
                sh 'sonar-scanner'
            } else {
                error 'No supported build file found (pom.xml or package.json)'
            }
        }
    }
}
