package main.classes;

public class Message {
	
	int groupId;
	String message;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = "message" + message;
	}
	
}
