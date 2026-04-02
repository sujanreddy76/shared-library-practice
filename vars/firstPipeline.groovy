import com.sujantech.builds.MavenBuild

def call(Map pipelineParams) {
   MavenBuild mavenBuild = new MavenBuild(this)
   pipeline {
    agent{
        label 'java-label'
    }
    environment{
        APPLICATION_NAME= "${pipelineParams.appName}"
    }
    tools{
        maven 'Maven_3.8.9'
    }
    stages{
        stage('Building the application'){
            steps {
                script{
                    mavenBuild.buildApp("$APPLICATION_NAME")
                }
            }

        }
    }
   }
}