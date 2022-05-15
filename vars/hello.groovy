def call(tomcatid,warname,credid) {
  sshagent(["${credid}"]) {
    echo "${credid}"
    sh "scp -o StrictHostKeyChecking=yes target/*.war ${tomcatid}:/home/ec2-user/tomcat8/webapps/${warname}.war"
    sh "ssh ${tomcatid} /home/ec2-user/tomcat8/bin/shutdown.sh"
    sh "ssh ${tomcatid} /home/ec2-user/tomcat8/bin/startup.sh"
   }
}
