package springtestingfeatures.server.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springtestingfeatures.server.ItemController;

@Configuration
@Import(D08_JdbcConfiguration.class)	
public class D10_ControllerConfiguration {
	
	@Bean 
	public ItemController itemController() {
		return new ItemController();
	}
}
