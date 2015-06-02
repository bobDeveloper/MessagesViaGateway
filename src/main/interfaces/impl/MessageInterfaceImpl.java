package main.interfaces.impl;

import main.interfaces.MessageInterface;

import org.apache.log4j.Logger;

public class MessageInterfaceImpl implements MessageInterface{
	
	public static final Logger logger = Logger.getLogger(MessageInterfaceImpl.class);
	
	@Override
	public void completed() {
		
		logger.debug("Message displayed!");
	}
}
