import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageSender1 {
    private static final String QUEUE_NAME = "GYM_QUEUE";

    public static void main(String... args) throws JMSException {

        ConnectionFactory connectionFactory
                = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.
                createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);

        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.
                createTextMessage("Hello ActiveMQ!");

        producer.send(message);
        System.out.println("Sending this message "
                + message.getText() + "to the " + QUEUE_NAME);

        connection.close();
    }
}
