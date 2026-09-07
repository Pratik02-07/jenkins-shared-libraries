def call() {
    timeout(time: 1, unit: "MINUTES") {
        // Waits for the SonarQube analysis to complete and checks its status
        waitForQualityGate abortPipeline: false
    }
}
