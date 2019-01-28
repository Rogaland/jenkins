FROM jenkins/jenkins:2.150.2-slim
COPY *.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
RUN echo 2.150.2 > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state
