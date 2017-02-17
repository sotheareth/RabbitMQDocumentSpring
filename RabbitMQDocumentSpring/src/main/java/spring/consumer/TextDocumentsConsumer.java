package spring.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import model.Document;

@Component("textConsumer")
public class TextDocumentsConsumer implements RabbitMQConsumer {
	
	private static final Logger log = LoggerFactory.getLogger(TextDocumentsConsumer.class);

	public void process(Document document) {
		log.debug("----------------------------Text Document received: " + document);
	}
}
