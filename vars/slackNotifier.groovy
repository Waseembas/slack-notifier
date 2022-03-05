#!/usr/bin/env groovy

def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "COMMITER: ${env.GIT_AUTHOR} with hash ${env.GIT_LAST_COMMIT} with buildnumber ${env.BUILD_NUMBER} on build Job ${env.JOB_NAME} was successful (<${env.BUILD_URL}|Open>)"
  }
  else if( buildResult == "FAILURE" ) { 
https://gitlab.com/qampus3/be/qampus-be/-/commit
   slackSend color: "danger", message: "${env.JOB_NAME} » ${env.branch}   (https://gitlab.com/qampus3/be/qampus-be/-/commit/${env.GIT_LAST_COMMIT} |${env.GIT_LAST_COMMIT}>)  configure context test cases » build (<${env.BUILD_URL}|${env.BUILD_NUMBER}>) » Started by user ${env.GIT_AUTHOR}"
  
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "COMMITER: ${env.GIT_AUTHOR} with hash ${env.GIT_LAST_COMMIT} with buildnumber ${env.BUILD_NUMBER} on build Job ${env.JOB_NAME} was unstable (<${env.BUILD_URL}|Open>)"
  }
  else {
    slackSend color: "danger", message: "COMMITER: ${env.GIT_AUTHOR} with hash ${env.GIT_LAST_COMMIT} with buildnumber ${env.BUILD_NUMBER} on build Job ${env.JOB_NAME} its result was canceled (<${env.BUILD_URL}|Open>)"	
  }
}
