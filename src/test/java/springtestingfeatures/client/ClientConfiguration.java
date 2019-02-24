package springtestingfeatures.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {
	
	@Bean
	public Client client() {
		return new Client();
	}
	
	@Bean 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}	
	
}
