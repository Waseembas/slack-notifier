#!/usr/bin/env groovy

def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "danger", message: "${env.JOB_NAME} » ${env.branch} (<${env.GIT_BASE}/${env.GIT_LAST_COMMIT}|${env.GIT_LAST_COMMIT}>)  configure context test cases success » build (<${env.BUILD_URL}|${env.BUILD_NUMBER}>) » fihish"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "${env.JOB_NAME} » ${env.branch} (<${env.GIT_BASE}/${env.GIT_LAST_COMMIT}|${env.GIT_LAST_COMMIT}>)  configure context test cases failure » build (<${env.BUILD_URL}|${env.BUILD_NUMBER}>) » finish"
  
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "danger", message: "${env.JOB_NAME} » ${env.branch} (<${env.GIT_BASE}/${env.GIT_LAST_COMMIT}|${env.GIT_LAST_COMMIT}>)  configure context test cases unstable » build (<${env.BUILD_URL}|${env.BUILD_NUMBER}>) » finish ${date}"
  }
  else {
    slackSend color: "danger", message: "${env.JOB_NAME} » ${env.branch} (<${env.GIT_BASE}/${env.GIT_LAST_COMMIT}|${env.GIT_LAST_COMMIT}>)  configure context test cases fail » build (<${env.BUILD_URL}|${env.BUILD_NUMBER}>) » finish ${date}"
  }
}
