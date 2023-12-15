package usersPackage;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import communicationsPackage.*;
import studyMaterialsPackage.*;

public class Teacher extends User{
    private Map<Course, Integer> marksToAssign = new HashMap<>();
    public Vector<String> requests;
    public Vector<UrgencyComplaint> urgencyComplaints;
    public Vector<Message> messages;
    
    {
    	requests = new Vector<>();
    	urgencyComplaints = new Vector<>();
    	messages = new Vector<>();
    }
    

    public Teacher(String name) {
        super(name);
    }

    public void assignMark(Student student, Course course, int score) {
        if (marksToAssign.containsKey(course)) {
            student.receiveMark(new Mark(course, score));
            System.out.println("Mark assigned successfully.");
        } else {
            System.out.println("You are not assigned to teach this course.");
        }
    }

    public void putMark(Student student, Course course, int score) {
        if (marksToAssign.containsKey(course)) {
            student.receiveMark(new Mark(course, score));
            System.out.println("Mark assigned successfully.");
        } else {
            System.out.println("You are not assigned to teach this course.");
        }
    }

    public void assignCourse(Course course) {
        marksToAssign.put(course, 0);
        System.out.println("You are now assigned to teach " + course.getCourseName());
    }

    public void seeNews() {
        System.out.println("Viewing news as a teacher.");
    }

    public void viewEnrolledStudents() {
        System.out.println("Viewing enrolled students as a teacher.");
    }
    
    // Method to send messages
    public void sendMessages(Vector<Message> messages) {
        // Assuming you want to add the messages to the Teacher's messages vector
        this.messages.addAll(messages);
		System.out.println(name + " sent messages.");
    }

    // Method to view messages
    public void viewMessages() {
        System.out.println("Messages for " + name + ":");
        for (Message message : messages) {
            System.out.println("Type: " + message.getMessageType() + ", Content: " + message.getText());
        }
    }

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
