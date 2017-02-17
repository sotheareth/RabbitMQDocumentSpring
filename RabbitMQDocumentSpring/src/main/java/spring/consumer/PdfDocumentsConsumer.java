package spring.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import model.Document;

@Component("pdfConsumer")
public class PdfDocumentsConsumer implements RabbitMQConsumer {
	private static final Logger log = LoggerFactory.getLogger(PdfDocumentsConsumer.class);

	public void process(Document document) {
		log.debug("----------------------------PDF Document received: " + document);
	}
}
