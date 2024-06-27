pipeline {
  agent any
  tools {
    maven 'MAVEN_3_8_7'
    jdk 'JDK_1_17'
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
            execute("mvn sonar:sonar -Dsonar.host.url=\"http://sonarqube:9000\" -Dsonar.login=admin -D sonar.password=admin123")
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
            execute("chmod +x ./deploy.sh")
            execute("./deploy.sh")
          }
        }
    }
  }
}

def execute(command){
  if(isUnix()){
    nohup sh "${command}"
  }else {
    bat "${command}"
  }
}
