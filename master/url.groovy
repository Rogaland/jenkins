def jlc = jenkins.model.JenkinsLocationConfiguration.get()
jlc.setUrl("https://jenkins.rogfk.no/")
jlc.setAdminAddress("ikt.drift@rogfk.no")
jlc.save() 
