package book;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSConsumer;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSRuntimeException;

public class Receiver {
	
	private ConnectionFactory connectionFactory;
	private Destination destination;

	public Receiver() throws NamingException {
		this.connectionFactory = InitialContext.doLookup("jms/RemoteConnectionFactory");
		this.destination = InitialContext.doLookup("jms/queue/playQueue");
	}

	private String receive() {
		String msg = null;
		try (JMSContext context = connectionFactory.createContext("john", "!1secret");) {
			JMSConsumer mc = context.createConsumer(destination);
			msg = mc.receiveBody(String.class);
		} catch (JMSRuntimeException re) {
			re.printStackTrace();
		}
		return msg;
	}

	public static void main(String[] args) throws NamingException {
		Receiver receiver = new Receiver();
		String msg = receiver.receive();
		System.out.println("Message: " + msg);
	}
}
