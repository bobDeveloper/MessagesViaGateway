package main.interfaces.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import main.classes.Message;
import main.interfaces.Gateway;
import main.interfaces.MessageInterface;

import org.apache.log4j.Logger;

public class GatewayImpl implements Gateway {
	// declare a logger for GatewayImpl Class
	public static final Logger logger = Logger.getLogger(GatewayImpl.class);
	public static final String SEPARATOR = ",";

	/*
	 * @param generatedMessage : list of messages that has been received
	 */
	public void sortMessageAndSend(List<Message> generatedMessage) {

		if (generatedMessage != null) {

			// create an iterator to iterate through generatedMessage
			Iterator<Message> msgIterator = generatedMessage.iterator();

			// create two lists that will store the group ID and the messages
			// grouped by groupID
			List<Integer> messagesGroupOrdered = new ArrayList<Integer>();
			List<String> messagesToBeSend = new ArrayList<String>();

			// check if the generatedMessage List has elements
			while (msgIterator.hasNext()) {
				Message msg = msgIterator.next();

				/*
				 * check if the message is not in a group and append it if it
				 * doesn't if it does append the message to the message from the
				 * group
				 */
				if (!messagesGroupOrdered.contains(msg.getGroupId())) {
					messagesGroupOrdered.add(msg.getGroupId());
					messagesToBeSend.add(msg.getMessage());
				} else {
					int indexToBeAdded = messagesGroupOrdered.indexOf(msg
							.getGroupId());
					String newMessages = messagesToBeSend.get(indexToBeAdded) + SEPARATOR + msg.getMessage();
					messagesToBeSend.remove(indexToBeAdded);
					messagesToBeSend.add(indexToBeAdded, newMessages);
				}
			}
			for (int idx = 0; idx < messagesGroupOrdered.size(); idx++) {
				Message message = new Message();
				message.setMessage(messagesToBeSend.get(idx));
				message.setGroupId(messagesGroupOrdered.get(idx));
				logger.debug(message.getMessage() + " with Group: "
						+ message.getGroupId());
				send(message);
			}
		}
	}

	/* } */

	// implements the send method from Gateway
	public void send(Message msg) {

		MessageInterface messageProcessed = new MessageInterfaceImpl();
		// split the messages from the same group
		String[] messages = msg.getMessage().split(SEPARATOR);
		// check if there are any messages in that group
		if (messages.length > 0)
			;
		{
			for (String message : messages) {
				logger.debug(message);
				messageProcessed.completed();
			}
		}
	}

	public List<Message> getMessages() {

		List<Message> messageList = new ArrayList<Message>();
		// create a Random instance for message generator
		Random randomGenerator = new Random();
		logger.debug("Starting generate message objects");

		// generate messages in random groups
		for (int idx = 1; idx <= 50; ++idx) {
			// get a value for groups between 0-9
			int randomInt = randomGenerator.nextInt(10);
			// create a new message that will be send to gateway
			Message msg = new Message();
			// set the message the groupId and message
			msg.setGroupId(randomInt);
			msg.setMessage("" + idx);
			messageList.add(msg);
			logger.debug("Message group is: " + randomInt
					+ " And the message is: " + msg.getMessage());
		}
		return messageList;
	}
}
