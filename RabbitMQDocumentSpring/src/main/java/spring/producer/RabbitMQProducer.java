package spring.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Document;

@Component("rabbitmqProducer")
public class RabbitMQProducer {
	
	private static final String EXCHANGE = "mydocuments";
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(Document document) {
		rabbitTemplate.convertAndSend(EXCHANGE, document.getType().getExtension(), document);
	}
}
