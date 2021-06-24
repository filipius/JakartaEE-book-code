package book;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Receiver {
    private ConnectionFactory cf;
    private Destination d;
    
    public Receiver() throws NamingException {
        this.cf = InitialContext.doLookup("jms/RemoteConnectionFactory");
        this.d = InitialContext.doLookup("jms/queue/QueueExample");
    }
    
    public String receive() {
        try (JMSContext cntxt = this.cf.createContext("john", "br1o+sa*")) {
            JMSConsumer cons = cntxt.createConsumer(d);
            return cons.receiveBody(String.class);
        }
    }
    
    public static void main(String[] args) throws NamingException {
        System.out.println(new Receiver().receive());
    }
    
    
}