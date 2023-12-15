package testClasses;

import java.util.Arrays;
import java.util.Vector;

import communicationsPackage.*;
import usersPackage.*;

public class MessageTest {

    public static void main(String[] args) {
        // Creating employees
        Employee employee1 = new Employee("John");
        Employee employee2 = new Employee("Alice");

        // Creating a teacher
        Teacher teacher = new Teacher("Professor Smith");

        // Creating messages
        Message message1 = new Message("Hello, how are you?", MessageType.TEXT);
        Message message2 = new Message("Can you review the report?", MessageType.REQUEST);
        Message message3 = new Message("Meeting at 2 PM.", MessageType.NOTIFICATION);

        // Sending messages between employees
        employee1.sendMessages(employee2, new Vector<>(Arrays.asList(message1, message2)));

        employee2.sendMessages(employee1, new Vector<>(Arrays.asList(message3)));

        // Sending messages from a teacher
        teacher.sendMessages(new Vector<>(Arrays.asList(message1, message2, message3)));

        // Viewing messages for employees
        employee1.viewIncomingMessages();
        employee1.viewOutgoingMessages();
        employee2.viewIncomingMessages();
        employee2.viewOutgoingMessages();

        // Viewing messages for the teacher
        teacher.viewMessages();
    }
}
