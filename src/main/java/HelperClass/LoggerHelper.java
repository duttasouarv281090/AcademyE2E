package HelperClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {

	public static Logger getLogger(Class clas)
	{
		Logger log=LogManager.getLogger(clas.getName());
		return log;
	}
}
