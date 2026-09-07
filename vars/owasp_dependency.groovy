def call(String projectType = 'maven') {
    stage('OWASP Dependency Scan') {
        echo "Running OWASP Dependency-Check for ${projectType}..."
        
        // Executes the dependency check tool installed in Jenkins
        dependencyCheck additionalArguments: '--format HTML --format XML', odcInstallation: 'OWASP-Dependency-Check'
        
        // Publishes the results back to the Jenkins UI
        dependencyCheckPublisher pattern: 'target/dependency-check-report.xml'
    }
}
