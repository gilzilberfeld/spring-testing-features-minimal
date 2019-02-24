package springtestingfeatures.server.configurations;

import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import springtestingfeatures.server.Logger;
public class D06_MockingPrototypeConfiguration {

	@Bean
	@Scope("prototype")
	public Logger mocklogger() {
		
		Logger mockLogger = Mockito.mock(Logger.class);
		when(mockLogger.isOn()).thenReturn(false);
		return mockLogger;
	}
}
