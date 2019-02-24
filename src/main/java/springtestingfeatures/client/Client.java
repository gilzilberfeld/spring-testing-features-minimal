package springtestingfeatures.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


public class Client {
	
	@Autowired RestTemplate template;
	
	public String getAllItems() {
		try {
			ResponseEntity<String> result =  
				template.getForEntity("/item/" , String.class);
			return result.getBody();
		}
		catch (HttpClientErrorException e) {
			if (e.getStatusCode()== HttpStatus.BAD_REQUEST)
				throw new ItemNotFoundException();
		}
		return "";
		
	}

}	
	
