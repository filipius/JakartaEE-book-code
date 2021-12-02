package beans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/playQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class MyMessageDrivenBean implements MessageListener {

	public void onMessage(Message message) {
		try {
			System.out.println(">>>>>>>>>>" + message.getBody(String.class));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
