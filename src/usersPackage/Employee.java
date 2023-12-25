package usersPackage;

import java.util.EventObject;
import java.util.Vector;

import communicationsPackage.*;

public class Employee extends User {
	public Vector<String> requests;
	private Vector<Message> workMessages;
	private Vector<Message> incomingMessages;  // Messages received by the employee
    private Vector<Message> outgoingMessages;  // Messages sent by the employee

    {
    	requests = new Vector<>();
    	workMessages = new Vector<>();
    	incomingMessages = new Vector<>();
    	outgoingMessages = new Vector<>();
    }
    
    public Employee() {
    	
    }
    
    public Employee(String name) {
        super(name);
        this.workMessages = workMessages != null ? workMessages : new Vector<>();
        this.requests = requests != null ? requests : new Vector<>();
        this.incomingMessages = new Vector<>();
        this.outgoingMessages = new Vector<>();
    }

	// Method to send messages
    public void sendMessages(Vector<Message> messages) {
        // Assuming you want to add the messages to the workMessages vector
        ((Vector<Message>) this.workMessages).addAll(messages);
        System.out.println(name + " sent messages.");
    }

 // Method to view work messages
    public void viewWorkMessages() {
        System.out.println("Work messages for " + name + ":");
        for (Message message : workMessages) {
            System.out.println("Type: " + message.getTypeOfMessage() + ", Content: " + message.getText());
        }
    }
	
    // Method to send messages to another employee
    public void sendMessages(Employee recipient, Vector<Message> messages) {
        // Create a new instance of Message for each message and add it to the sender's outgoingMessages
        for (Message message : messages) {
            outgoingMessages.add(message);
            // Add the same message to the recipient's incomingMessages
            recipient.incomingMessages.add(message);
        }
        System.out.println(name + " sent messages to " + recipient.name + ".");
    }
   
 // Method to view incoming messages
    public void viewIncomingMessages() {
        System.out.println("Incoming messages for " + name + ":");
        for (Message message : incomingMessages) {
            System.out.println("Type: " + message.getTypeOfMessage() + ", Content: " + message.getText());
        }
    }
    
 // Method to view outgoing messages
    public void viewOutgoingMessages() {
        System.out.println("Outgoing messages from " + name + ":");
        for (Message message : outgoingMessages) {
            System.out.println("Type: " + message.getTypeOfMessage() + ", Content: " + message.getText());
        }
    }

	@Override
	public int compareTo(User o) {
		return super.compareTo(o);
	}
}
