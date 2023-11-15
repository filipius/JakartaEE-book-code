package book;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSConsumer;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSException;
import jakarta.jms.JMSRuntimeException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

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