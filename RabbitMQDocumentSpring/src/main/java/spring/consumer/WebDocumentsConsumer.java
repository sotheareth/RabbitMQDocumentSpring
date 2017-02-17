package spring.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import model.Document;

@Component("webConsumer")
public class WebDocumentsConsumer implements RabbitMQConsumer {
	private static final Logger log = LoggerFactory.getLogger(WebDocumentsConsumer.class);

	public void process(Document document) {
		log.debug("----------------------------Web Document received: " + document);
	}
}