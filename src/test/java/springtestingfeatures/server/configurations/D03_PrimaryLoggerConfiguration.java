package springtestingfeatures.server.configurations;

import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import springtestingfeatures.configurations.App_LoggerConfiguration;
import springtestingfeatures.server.Logger;

@Configuration
@Import(App_LoggerConfiguration.class)
public class D03_PrimaryLoggerConfiguration {

	@Primary
	@Bean
	public Logger mocklogger() {
		
		Logger mockLogger = Mockito.mock(Logger.class);
		when(mockLogger.isOn()).thenReturn(false);
		return mockLogger;
	}

}
