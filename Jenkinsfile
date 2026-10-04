pipeline {

    agent any

    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'edge'],
            description: 'Select browser'
        )
    }

    environment {
        TEST_ENV = 'QA'
    }

    stages {

        stage('Test') {
            steps {
                bat '"C:\\apache-maven\\apache-maven-3.9.16\\bin\\mvn.cmd" clean test -Dbrowser=%BROWSER%'
            }
        }
    }

    post {

        always {
            echo "Test execution completed"

            publishHTML([
                reportDir: 'reports',
                reportFiles: 'Extent_Report.html',
                reportName: 'Extent Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])
        }

        success {
            echo "Tests passed successfully"
        }

        failure {
            echo "Tests failed"
        }
    }
}

//testing weabhooks
