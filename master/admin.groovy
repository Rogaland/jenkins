def hudsonRealm = new hudson.security.HudsonPrivateSecurityRealm(false)
def adminUsername = System.getenv('JENKINS_ADMIN_USERNAME') ?: 'admin'
def adminPassword = System.getenv('JENKINS_ADMIN_PASSWORD') ?: 'password'
hudsonRealm.createAccount(adminUsername, adminPassword)
//hudsonRealm.createAccount("charles", "charles")

def strategy = new hudson.security.FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)

def instance = jenkins.model.Jenkins.getInstance()
instance.setAuthorizationStrategy(strategy)
instance.setSecurityRealm(hudsonRealm)
instance.save()
