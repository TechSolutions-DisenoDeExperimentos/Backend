pipeline {
  agent any
  tools {
    maven 'MAVEN_3_9_6'
    jdk 'JDK_1_11'
  }

  stages {
    stage('Clean') {
        steps {
            echo 'Cleaning..'
            execute("mvn clean")
        }
    }
    stage('Test') {
        steps {
            echo 'Testing..'
            execute("mvn test")
        }
    }
    stage('Report') {
        steps {
            echo 'Reporting with jacoco..'
            execute("mvn jacoco:report")
        }
    }
    stage('Sonar') {
        steps {
            echo 'Sonar report..'
            execute("mvn sonar:sonar")
        }
    }
    stage('Build') {
        steps {
            echo 'Building..'
            execute("mvn package -D"maven.test.skip"")
        }
    }
    stage('Deploy') {
        steps {
            echo 'Deploying....'
            execute("java -jar ./target/TuCine-0.0.1-SNAPSHOT.jar")
        }
    }
  }
}

def execute(def args){
  if(isUnix()){
    sh args
  }else {
    bat args
  }
}
