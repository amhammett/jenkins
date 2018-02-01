import jenkins.model.*
import hudson.security.*

def jenkins = Jenkins.getInstance()
jenkins.setSecurityRealm(new HudsonfPrivateSecurityRealm(false))
jenkins.setAuthorizationStrategy(new GlobalMatrixAuthorizationStrategy())

def user = jenkins.getSecurityRealm().createAccount(JENKINS_USER, JENKINS_PASS)
user.save()

jenkins.getAuthorizationStrategy().add(Jenkins.ADMINISTER, JENKINS_USER)
jenkins.save()
