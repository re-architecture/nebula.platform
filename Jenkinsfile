pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(url: 'https://github.com/re-architecture/nebula.platform', branch: 'master', poll: true)
      }
    }
  }
}