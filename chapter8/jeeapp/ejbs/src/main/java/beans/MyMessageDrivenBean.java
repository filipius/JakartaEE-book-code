package beans;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/playQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue") })
public class MyMessageDrivenBean implements MessageListener {

	public void onMessage(Message message) {
		try {
			System.out.println(">>>>>>>>>>" + message.getBody(String.class));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
