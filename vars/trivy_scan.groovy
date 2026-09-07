def call(String scanTarget, String scanType = 'image') {
    stage('Trivy Security Scan') {
        echo "Running Trivy ${scanType} scan on: ${scanTarget}"
        
        // Flags ensure the pipeline fails if CRITICAL vulnerabilities are found
        if (scanType == 'image') {
            sh "trivy image --exit-code 1 --severity CRITICAL,HIGH ${scanTarget}"
        } else {
            sh "trivy fs --exit-code 1 --severity CRITICAL,HIGH ."
        }
    }
}
