package book;

import java.io.IOException;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSRuntimeException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AsyncReceiver implements MessageListener {
	private ConnectionFactory connectionFactory;
	private Destination destination;

	public AsyncReceiver() throws NamingException {
		this.connectionFactory = InitialContext.doLookup("jms/RemoteConnectionFactory");
		this.destination = InitialContext.doLookup("jms/queue/playQueue");

	}

	@Override
	public void onMessage(Message msg) {
		TextMessage textMsg = (TextMessage) msg;
		try {
			System.out.println("Got message: " + textMsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void launch_and_wait() {
		try (JMSContext context = connectionFactory.createContext("john", "!1secret");) {
			JMSConsumer consumer = context.createConsumer(destination);
			consumer.setMessageListener(this);
			System.out.println("Press enter to finish...");
			System.in.read();
		} catch (JMSRuntimeException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws NamingException, IOException {
		AsyncReceiver asyncReceiver = new AsyncReceiver();
		asyncReceiver.launch_and_wait();
	}
}