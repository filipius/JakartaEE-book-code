package book;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSProducer;

public class Sender {

	private ConnectionFactory connectionFactory;
	private Destination destination;

	public Sender() throws NamingException {
		this.connectionFactory = InitialContext.doLookup("jms/RemoteConnectionFactory");
		this.destination = InitialContext.doLookup("jms/queue/playQueue");
	}

	private void send(String text) {
		try (JMSContext context = connectionFactory.createContext("john", "!1secret");) {
			JMSProducer messageProducer = context.createProducer();
			messageProducer.send(destination, text);
		} catch (Exception re) {
			re.printStackTrace();
		}
	}

	public static void main(String[] args) throws NamingException {
		Sender sender = new Sender();
		sender.send("Hello Receiver!");
		System.out.println("Finished sender...");
	}
}