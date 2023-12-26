package communicationsPackage;
import usersPackage.Employee;

/**
 * The {@code Message} class represents a communication message, including its type, topic, urgency,
 * text content, and sender.
 *
 * <p>Messages can vary in type, topic, and urgency levels, and are sent by employees within the system.</p>
 *
 * <p>This class offers constructors and methods for accessing and modifying the properties of a message.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-01-01
 */
public class Message {

    /** The type of the message. */
    public MessageType typeOfMessage;

    /** The topic of the message. */
    public String topic;

    /** The urgency level of the message. */
    public UrgencyLevel urgency;

    /** The text content of the message. */
    public String text;

    /** The sender of the message. */
    public Employee sender;

    /**
     * Constructs an empty {@code Message}.
     */
    public Message() {

    }

    /**
     * Constructs a {@code Message} with the specified text and type.
     *
     * @param text the content of the message
     * @param type the type of the message
     */
    public Message(String text, MessageType type) {
        typeOfMessage = type;
        this.text = text;
    }

    /**
     * Constructs a {@code Message} with the specified parameters.
     *
     * @param typeOfMessage the type of the message
     * @param topic the topic of the message
     * @param urgency the urgency level of the message
     * @param text the content of the message
     * @param sender the sender of the message
     */
    public Message(MessageType typeOfMessage, String topic, UrgencyLevel urgency, String text, Employee sender) {
        this.typeOfMessage = typeOfMessage;
        this.topic = topic;
        this.urgency = urgency;
        this.text = text;
        this.sender = sender;
    }

    /**
     * Retrieves the type of the message.
     *
     * @return the type of the message
     */
    public MessageType getTypeOfMessage() {
        return typeOfMessage;
    }

    /**
     * Sets the type of the message.
     *
     * @param typeOfMessage the type of the message
     */
    public void setTypeOfMessage(MessageType typeOfMessage) {
        this.typeOfMessage = typeOfMessage;
    }

    /**
     * Retrieves the topic of the message.
     *
     * @return the topic of the message
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Sets the topic of the message.
     *
     * @param topic the topic of the message
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Retrieves the urgency level of the message.
     *
     * @return the urgency level of the message
     */
    public UrgencyLevel getUrgency() {
        return urgency;
    }

    /**
     * Sets the urgency level of the message.
     *
     * @param urgency the urgency level of the message
     */
    public void setUrgency(UrgencyLevel urgency) {
        this.urgency = urgency;
    }

    /**
     * Retrieves the content of the message.
     *
     * @return the content of the message
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the content of the message.
     *
     * @param text the content of the message
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns a string representation of the message.
     *
     * @return a string representation of the message
     */
    @Override
    public String toString() {
        return topic + " " + text;
    }
}
