def call(tomcatid,warname,credid) {
  sshagent(["${credid}"]) {
    echo "${credid}"
    echo "${tomcatid}"
    echo "${warname}"
    sh "scp -o StrictHostKeyChecking=no target/*.war ec2-user@${tomcatid}:/home/ec2-user/tomcat8/webapps/${warname}.war"
    sh "ssh ec2-user@${tomcatid} /home/ec2-user/tomcat8/bin/shutdown.sh"
    sh "ssh ec2-user@${tomcatid} /home/ec2-user/tomcat8/bin/startup.sh"
   }
}
