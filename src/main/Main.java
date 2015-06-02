package main;

import java.util.List;

import org.apache.log4j.Logger;

import main.classes.Message;
import main.interfaces.Gateway;
import main.interfaces.impl.GatewayImpl;

public class Main {
	final static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
	
		new Thread("firstThread") {
			synchronized public void run() {
				long startTimeMillis = System.currentTimeMillis();
				logger.debug(Thread.currentThread().getName() + " is running");
				logger.debug("Accessing first resource");
				Gateway gateway = new GatewayImpl();
				List<Message> generatedMessages = gateway.getMessages();
				gateway.sortMessageAndSend(generatedMessages);
				logger.debug(Thread.currentThread().getName() + " done");
				logger.debug("First resource cleared");
				logger.debug("Has been done in: " + (System.currentTimeMillis() - startTimeMillis));
			}
		}.start();
	}
	
}
