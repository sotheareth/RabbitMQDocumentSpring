package spring.consumer;

import model.Document;

public interface RabbitMQConsumer {

	public void process(Document document);
	
}
