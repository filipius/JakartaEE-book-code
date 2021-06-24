package book;

import java.io.IOException;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AsyncReceiver implements MessageListener {
    private ConnectionFactory cf;
    private Destination d;
    
    public AsyncReceiver() throws NamingException {
        this.cf = InitialContext.doLookup("jms/RemoteConnectionFactory");
        this.d = InitialContext.doLookup("jms/queue/QueueExample");
    }
    
    @Override
    public void onMessage(Message msg) {
        try {
            System.out.println(((TextMessage) msg).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
    public void receive() throws IOException {
        try (JMSContext cntxt = this.cf.createContext("john", "br1o+sa*")) {
            JMSConsumer cons = cntxt.createConsumer(d);
            cons.setMessageListener(this);
            System.in.read();
        }
    }
    
    public static void main(String[] args) throws NamingException, IOException {
        new AsyncReceiver().receive();
    }
}