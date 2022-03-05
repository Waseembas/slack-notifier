#!/usr/bin/env groovy

def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "danger", message: "${env.JOB_NAME} » ${env.branch} (<${env.GIT_BASE}/${env.GIT_LAST_COMMIT}|${env.GIT_LAST_COMMIT}>)  configure context test cases » build (<${env.BUILD_URL}|${env.BUILD_NUMBER}>) » Started by user ${env.GIT_AUTHOR}"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "${env.JOB_NAME} » ${env.branch} (<${env.GIT_BASE}/${env.GIT_LAST_COMMIT}|${env.GIT_LAST_COMMIT}>)  configure context test cases » build (<${env.BUILD_URL}|${env.BUILD_NUMBER}>) » Started by user ${env.GIT_AUTHOR}"
  
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "danger", message: "${env.JOB_NAME} » ${env.branch} (<${env.GIT_BASE}/${env.GIT_LAST_COMMIT}|${env.GIT_LAST_COMMIT}>)  configure context test cases » build (<${env.BUILD_URL}|${env.BUILD_NUMBER}>) » Started by user ${env.GIT_AUTHOR}"
  }
  else {
    slackSend color: "danger", message: "${env.JOB_NAME} » ${env.branch} (<${env.GIT_BASE}/${env.GIT_LAST_COMMIT}|${env.GIT_LAST_COMMIT}>)  configure context test cases » build (<${env.BUILD_URL}|${env.BUILD_NUMBER}>) » Started by user ${env.GIT_AUTHOR}"
  }
}
