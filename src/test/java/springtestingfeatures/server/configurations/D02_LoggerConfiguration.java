package springtestingfeatures.server.configurations;

import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springtestingfeatures.configurations.App_LogReaderConfiguration;
import springtestingfeatures.server.Logger;

@Configuration
@Import(App_LogReaderConfiguration.class)	
public class D02_LoggerConfiguration {

	@Bean
	public Logger mocklogger() {
		
		Logger mockLogger = Mockito.mock(Logger.class);
		when(mockLogger.isOn()).thenReturn(false);
		return mockLogger;
	}
}
