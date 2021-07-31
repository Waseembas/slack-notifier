#!/usr/bin/env groovy

def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "COMMITER: ${env.GIT_AUTHOR} with hash ${env.GIT_LAST_COMMIT} with buildnumber ${env.BUILD_NUMBER} on build Job ${env.JOB_NAME} was successful"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "COMMITER: ${env.GIT_AUTHOR} with hash ${env.GIT_LAST_COMMIT} with buildnumber ${env.BUILD_NUMBER} on build Job ${env.JOB_NAME} was failed"
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "COMMITER: ${env.GIT_AUTHOR} with hash ${env.GIT_LAST_COMMIT} with buildnumber ${env.BUILD_NUMBER} on build Job ${env.JOB_NAME} was unstable"
  }
  else {
    slackSend color: "danger", message: "COMMITER: ${env.GIT_AUTHOR} with hash ${env.GIT_LAST_COMMIT} with buildnumber ${env.BUILD_NUMBER} on build Job ${env.JOB_NAME} its result was unclear"	
  }
}
