package main.interfaces;

import java.util.List;

import main.classes.Message;

public interface Gateway {
	
	public void sortMessageAndSend(List<Message> generatedMessage);
	
	public void send(Message msg);
	
	public List<Message> getMessages();
}
