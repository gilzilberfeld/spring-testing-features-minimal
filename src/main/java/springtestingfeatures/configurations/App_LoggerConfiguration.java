package springtestingfeatures.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springtestingfeatures.server.Logger;

@Configuration
public class App_LoggerConfiguration {

	@Bean
	public Logger logger() 	{
		return new Logger();
	}
}
