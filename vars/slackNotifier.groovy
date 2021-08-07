#!/usr/bin/env groovy

def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "COMMITER: ${env.GIT_AUTHOR} with hash ${env.GIT_LAST_COMMIT} with buildnumber ${env.BUILD_NUMBER} on build Job ${env.JOB_NAME} was successful (<${env.BUILD_URL}|Open>)"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "COMMITER: ${env.GIT_AUTHOR} with hash ${env.GIT_LAST_COMMIT} with buildnumber ${env.BUILD_NUMBER} on build Job ${env.JOB_NAME} was failed (<${env.BUILD_URL}|Open>)"
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "COMMITER: ${env.GIT_AUTHOR} with hash ${env.GIT_LAST_COMMIT} with buildnumber ${env.BUILD_NUMBER} on build Job ${env.JOB_NAME} was unstable (<${env.BUILD_URL}|Open>)"
  }
  else {
    slackSend color: "danger", message: "COMMITER: ${env.GIT_AUTHOR} with hash ${env.GIT_LAST_COMMIT} with buildnumber ${env.BUILD_NUMBER} on build Job ${env.JOB_NAME} its result was canceled (<${env.BUILD_URL}|Open>)"	
  }
}


(<${env.BUILD_URL}|Open>) 
