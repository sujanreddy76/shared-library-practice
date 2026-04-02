import com.sujantech.builds.MavenBuild

def call(Map pipelineParams) {
   MavenBuild mavenBuild = new newMavenBuild(this)
   pipeline {
    agent{
        label 'java-label'
    }
    environment{
        APPLICATION_NAME="${pipelineParams.appName}"
    }
    stages{
        stage("Building the $APPLICATION_NAME application"){
            steps {
                script{
                    mavenBuild.buildApp("$APPLICATION_NAME")
                }
            }

        }
    }
   }
}