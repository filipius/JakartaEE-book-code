package book;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Sender {
    private ConnectionFactory cf;
    private Destination d;
    
    
    public Sender() throws NamingException {
        this.cf = InitialContext.doLookup("jms/RemoteConnectionFactory");
        this.d = InitialContext.doLookup("jms/queue/QueueExample");
    }
    
    public void send(String msg) {
        try (JMSContext cntx = this.cf.createContext("john", "br1o+sa*")) {
            JMSProducer prod = cntx.createProducer();
            prod.send(d, msg);
        }
    }
    
    public static void main(String[] args) throws NamingException {
        new Sender().send("Hello World, JMS!");
    }
    
    
}
