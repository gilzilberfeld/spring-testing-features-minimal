package springtestingfeatures.server;

import org.springframework.beans.factory.annotation.Autowired;


public class LogReader{
	
	@Autowired Logger logger;
	
	public String getLogAsString() {
		if (logger.isOn()){
				return logger.toString();
		}
		else
			return "Logging is off";
	}

}
