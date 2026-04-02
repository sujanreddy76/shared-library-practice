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