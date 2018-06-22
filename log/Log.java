package log;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
	public Logger logger;
	FileHandler fh;
	ConsoleHandler ch;
	public Log(String fileName) throws SecurityException,IOException {
		File file = new File(fileName);
		if(!file.exists()) {
			file.createNewFile();
		}
		logger =Logger.getLogger(System.currentTimeMillis()+"");
		logger.setUseParentHandlers(false);
		
		fh=new FileHandler(fileName, true);
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		fh.setLevel(Level.ALL);
		
		ch=new ConsoleHandler();
		logger.addHandler(ch);
		ch.setLevel(Level.SEVERE);
		// TODO Auto-generated constructor stub
	}
	

}
