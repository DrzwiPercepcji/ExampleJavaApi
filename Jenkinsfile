node {
    def app

    stage('Build') {
        checkout scm

        echo 'Building...'
        app = docker.build("example/recruitment-api", "--no-cache -f Dockerfile .")
    }
    stage('Test') {
        echo 'Testing...'

        app.inside('--entrypoint ""') {
            sh 'cp /app/junit.xml ${WORKSPACE}'
        }
        junit 'junit.xml'
    }
    stage('Publish') {
        echo 'Publishing...'

        docker.withRegistry('https://registry.example.com', 'Registry') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}