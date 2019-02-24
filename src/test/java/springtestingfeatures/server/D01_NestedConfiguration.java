package springtestingfeatures.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import springtestingfeatures.configurations.App_LogReaderConfiguration;
import springtestingfeatures.server.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class D01_NestedConfiguration {

	@Test
	public void contextLoads() {
	}


	@Configuration
	@Import(App_LogReaderConfiguration.class)	
	static class NestedConfiguration {
		
		@Bean
		public Logger logger() {
			return mock(Logger.class);
		}
	}
}
