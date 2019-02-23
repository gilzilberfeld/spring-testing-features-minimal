package springtestingfeatures.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springtestingfeatures.server.LogReader;
import springtestingfeatures.server.Logger;

@Configuration
public class App_LogReaderConfiguration {
	
	@Bean
	public LogReader reader() {
		return new LogReader();
	}
	
}
