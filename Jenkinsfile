pipeline {

    agent any

    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'edge'],
            description: 'Select browser'
        )
    }

    stages {

        stage('Test') {
            steps {
                bat '"C:\\apache-maven\\apache-maven-3.9.16\\bin\\mvn.cmd" clean test -Dbrowser=%BROWSER%'
            }
        }
    }
}