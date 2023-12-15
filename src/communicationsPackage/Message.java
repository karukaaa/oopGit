package communicationsPackage;

public class Message {
	public MessageType typeOfMessage;
	public String topic;
	public Urgency urgency;
	public String text;
	
	Message(MessageType typeOfMessage, String topic, Urgency urgency, String text) {
		this.typeOfMessage = typeOfMessage;
		this.topic = topic;
		this.urgency = urgency;
		this.text = text;
	}

	public Message(String string, MessageType text2) {
		// TODO Auto-generated constructor stub
	}

	public String getMessageType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUrgency() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
