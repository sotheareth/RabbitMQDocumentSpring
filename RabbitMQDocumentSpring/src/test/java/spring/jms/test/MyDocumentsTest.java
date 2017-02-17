package spring.jms.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Document;
import model.Type;
import spring.producer.RabbitMQProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class MyDocumentsTest {

	private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);

	@Autowired
	RabbitMQProducer rabbitmqProducer;

	@Test
	public void testProducer() throws InterruptedException {

		log.debug("Testing RabbitMQ producer...");
		assertNotNull(rabbitmqProducer);

		List<Document> list = getDocumentList();
		for(Document document : list) {
			rabbitmqProducer.send(document );
			
			Thread.sleep(5000);
		}
		
	}
	
	private List<Document> getDocumentList(){
		
		List<Document> result= new ArrayList<Document>();
		
		Document document = new Document();
		document.setDocumentId("1acbb68a-a859-49c9-ac88-d9e9322bac55");
		document.setName("Book Template");
		document.setLocation("/docs/isfbook/Documents/Random/Book Template.pdf");
		document.setDescription("A book template for creating new books");
		document.setCreated(new Date());
		document.setModified(new Date());
		
		Type type = new Type();
		type.setTypeId("41e2d211-6396-4f23-9690-77bc2820d84b");
		type.setName("PDF");
		type.setExtension(".pdf");
		type.setDesc("Portable Document Format");
		document.setType(type);
		
		
		Document document2 = new Document();
		document2.setDocumentId("3580f482-7f12-4787-bb60-c98023d47b6c");
		document2.setName("Clustering with RabbitMQ");
		document2.setLocation("/Users/isfbook/Documents/Random/Clustering with RabbitMQ.txt");
		document2.setDescription("Simple notes");
		document2.setCreated(new Date());
		document2.setModified(new Date());
		
		Type type2 = new Type();
		type2.setTypeId("e8e5310b-6345-4d08-86b6-d5c3c299aa7f");
		type2.setName("NOTE");
		type2.setDesc("Text Notes");
		type2.setExtension(".txt");
		document2.setType(type2);
		
		Document document3 = new Document();
		document3.setDocumentId("431cddbf-f3c0-4076-8c1c-564e7dce16c9");
		document3.setName("Pro Spring Security Book");
		document3.setLocation("http://www.apress.com/9781430248187");
		document3.setDescription("Excellent Book");
		document3.setCreated(new Date());
		document3.setModified(new Date());
		
		Type type3 = new Type();
		type3.setTypeId("4980d2e4-a424-4ff4-a0b2-476039682f43");
		type3.setName("WEB");
		type3.setDesc("Web Link");
		type3.setExtension(".url");
		document3.setType(type3);
		
		result.add(document);
		result.add(document2);
		result.add(document3);
		
		return result;
	}
}
