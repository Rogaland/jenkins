def cutoff = new Date().minus(30)
println cutoff

def instance = jenkins.model.Jenkins.getInstance()
def jobs = instance.items;

println "Start deleting builds older than ${cutoff}"

def count = 0

for (folder in jobs) {
  if (folder instanceof jenkins.branch.OrganizationFolder) {
    for (project in folder.items) {
      for (branch in project.items) {
        branch.builds.findAll { it.time < cutoff }.each { try { it.delete(); ++count } catch (IOException e) {} }
      }
    }
  }
}

println "Deleted ${count} builds"
