package springtestingfeatures.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import springtestingfeatures.server.configurations.D2_TestLoggerConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {D2_TestLoggerConfiguration.class})
public class D02_ImportedConfigurationTests{

	@Autowired LogReader reader;
	
	@Test
	public void whenLoggerIsOff_returnError() {
		assertEquals("Logging is off", reader.getLogAsString());
	}
}
