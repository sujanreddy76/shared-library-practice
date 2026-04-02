package com.sujantech.builds

class MavenBuild {
    def jenkins
    MavenBuild(jenkins) {
        this.jenkins = jenkins
    }
    def buildApp(appName) {
        jenkins.sh """
        echo "Building the Maven for $appName project using shared library"
        mvn package -DskipTests=true
        """
    }
}