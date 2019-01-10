pipeline {
    agent any
    triggers {
        cron('* * * * * ')
    }
    stages{
        stage("Git Clone"){
            steps{
                git 'git@github.com:kolomyya/webserver_with_jenkins.git'
            }
        }
        stage ("Copy file to web" ){
            steps{
                sh "cp -f index.html /var/www/html/index.html"
            }
        }
        stage("Test"){
            steps{
                sh "echo Test"
            }
        }
    }
}
