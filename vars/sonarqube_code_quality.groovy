def call(int timeoutMinutes = 10) {
    stage('SonarQube Quality Gate') {
        // Pauses pipeline until SonarQube webhooks report back the status
        timeout(time: timeoutMinutes, unit: 'MINUTES') {
            def gate = waitForQualityGate()
            if (gate.status != 'OK') {
                error "Pipeline aborted due to SonarQube Quality Gate failure: ${gate.status}"
            } else {
                echo "SonarQube Quality Gate Passed!"
            }
        }
    }
}
