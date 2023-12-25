package communicationsPackage;

import usersPackage.Employee;

public class Message {
	public MessageType typeOfMessage;
	public String topic;
	public UrgencyLevel urgency;
	public String text;
	public Employee sender;
	
	public Message() {
		
	}
	public Message(String text, MessageType type) {
		typeOfMessage = type;
		this.text = text;
	}
	public Message(MessageType typeOfMessage, String topic, UrgencyLevel urgency, String text, Employee sender) {
		this.typeOfMessage = typeOfMessage;
		this.topic = topic;
		this.urgency = urgency;
		this.text = text;
		this.sender = sender;
	}
	public MessageType getTypeOfMessage() {
		return typeOfMessage;
	}
	public void setTypeOfMessage(MessageType typeOfMessage) {
		this.typeOfMessage = typeOfMessage;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public UrgencyLevel getUrgency() {
		return urgency;
	}
	public void setUrgency(UrgencyLevel urgency) {
		this.urgency = urgency;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String toString() {
		return topic + " " + text;
	}
}
