package springtestingfeatures.server;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Flow.Publisher;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import springtestingfeatures.configurations.App_LogReaderConfiguration;
import springtestingfeatures.server.configurations.D02_LoggerConfiguration;
import springtestingfeatures.server.configurations.D06_MockingPrototypeConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {App_LogReaderConfiguration.class,
								D02_LoggerConfiguration.class})
public class D05_Mocking_SingletonWithResets{

	@Autowired Logger mockLogger;
	
	@Before
	public void setup()	{
		Mockito.reset(mockLogger);
	}
	
	@Test
	public void firstTest() {
		mockLogger.isOn();
		Mockito.verify(mockLogger).isOn();
	}
	
	@Test
	public void secondTest() {
		verify(mockLogger, never()).isOn();
	}
}
