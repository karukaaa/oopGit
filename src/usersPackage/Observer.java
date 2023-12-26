package usersPackage;
/**
 * The {@code Observer} interface represents an observer in the Observer design pattern.
 *
 * <p>Objects that implement this interface can be registered as observers to receive updates
 * when the state of the observed subject changes.</p>
 *
 * <p>Implementing classes must provide the {@code update} method to handle updates from the subject.</p>
 *
 * @version 1.0
 * @since 2023-01-01
 */
public interface Observer {
    /**
     * Updates the observer with a new message from the observed subject.
     *
     * @param message the message containing information about the state change
     */
    void update(String message);
}
