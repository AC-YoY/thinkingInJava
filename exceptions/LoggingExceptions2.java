package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingExceptions2 {
	public static void main(String[] args) {
		try{
			throw new NullPointerException();
		}catch(Exception e){
			//Attention!! logException就是这么用的！
			logException(e);
		}
		
	}
	
	private static Logger logger = 
			Logger.getLogger("Logging.Exception.2");
	//不用constructor的话我们就用个static的instance initialization
//	public LoggingExceptions2(){
//		StringWriter stringWriter = new StringWriter();
//		PrintWriter printWriter = new PrintWriter(stringWriter);
//		
//	}
	static void logException(Exception e){
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		logger.severe(stringWriter.toString());
	}
	
	
}
