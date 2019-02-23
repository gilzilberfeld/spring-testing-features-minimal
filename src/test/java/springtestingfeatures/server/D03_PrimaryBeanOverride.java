package springtestingfeatures.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import springtestingfeatures.configurations.App_LogReaderConfiguration;
import springtestingfeatures.server.configurations.D3_TestPrimaryLoggerConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {App_LogReaderConfiguration.class,
								D3_TestPrimaryLoggerConfiguration.class})
public class D03_PrimaryBeanOverride {
	
	@Autowired LogReader reader;
	
	@Test
	public void whenLoggerIsOff_returnError() {
		assertEquals("Logging is off", reader.getLogAsString());
	}

}
