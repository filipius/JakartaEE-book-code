#! /bin/sh

#start wildfly
/opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 &

#install the driver and the data source
#the challenge is to have the server ready---it may take a while
ready=0
while [ $ready -eq 0 ]
do
    /opt/jboss/wildfly/bin/jboss-cli.sh "connect","deploy --url=https://jdbc.postgresql.org/download/postgresql-42.2.22.jar","data-source add --name=PostgreDS --driver-name=postgresql-42.2.22.jar  --driver-class=org.postgresql.Driver --jndi-name=java:/PostgresDS --connection-url=jdbc:postgresql://database:5432/school  --user-name=postgres --password=My01pass"
    if [ $? -eq 0 ]
    then
        ready=1
    fi
    sleep 1
done

#keep running forever
tail -f /dev/null
