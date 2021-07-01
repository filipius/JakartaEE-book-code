FROM jboss/wildfly:24.0.0.Final
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin#7rules --silent
ADD --chmod=0755 wildfly-init-config.sh /opt/jboss/wildfly/bin
CMD ["/opt/jboss/wildfly/bin/wildfly-init-config.sh"]