package springtestingfeatures.client;

import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;



@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes= {ClientConfiguration.class})
public class D11_Client {
	
	@Autowired RestTemplate template;
	@Autowired Client	client;
	
	MockRestServiceServer mockServer;
	
	@Before
	public void setup() {
		mockServer = MockRestServiceServer.createServer(template);
	}
	
	@Test
	public void get_ServerCalledCorrectly() {
		mockServer
				.expect(once(), requestTo("/item/"))
				.andRespond(
						withSuccess("", MediaType.TEXT_PLAIN));
		client.getAllItems();
		mockServer.verify();
	}
	
	@Test (expected = ItemNotFoundException.class)
	public void add_ThrowsOnError() {
		mockServer.expect(once(), requestTo("/item/"))
			.andRespond(withBadRequest());
		client.getAllItems();
	}
}


