pipeline {
  agent any
  tools {
    maven 'MAVEN_3_9_6'
    jdk 'JDK_1_11'
  }

  stages {
    stage('Clean') {
        steps {
          script {
            echo 'Cleaning..'
            execute("mvn clean")
          }
        }
    }
    stage('Test') {
        steps {
          script {
            echo 'Testing..'
            execute("mvn test")
          }
        }
    }
    stage('Report') {
        steps {
          script {
            echo 'Reporting with jacoco..'
            execute("mvn jacoco:report")
          }
        }
    }
    stage('Sonar') {
        steps {
          script {
            echo 'Sonar report..'
            execute("mvn sonar:sonar")
          }
        }
    }
    stage('Build') {
        steps {
          script {
            echo 'Building..'
            execute("mvn package -D\"maven.test.skip\"")
          }
        }
    }
    stage('Deploy') {
        steps {
          script {
            echo 'Deploying....'
            execute("java -jar ./target/TuCine-0.0.1-SNAPSHOT.jar")
          }
        }
    }
  }
}

def execute(command){
  if(isUnix()){
    sh "${command}"
  }else {
    bat "${command}"
  }
}
