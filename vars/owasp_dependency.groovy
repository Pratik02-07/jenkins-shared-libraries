def call() {
    // You must wrap steps inside a block or step scope depending on how it's executed
    dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
