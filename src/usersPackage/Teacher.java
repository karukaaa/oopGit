package usersPackage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import communicationsPackage.*;
import studyMaterialsPackage.*;



public class Teacher extends User{
	private List<Course> courses = new ArrayList<>();
    private Map<Course, Integer> marksToAssign = new HashMap<>();
    public Vector<String> requests;
    public Vector<UrgencyComplaint> urgencyComplaints;
    public Vector<Message> messages;
    
    public Teacher() {
    	
    }
    
    public Teacher(String name) {
    	super(name);
    }

    public void putMark(Student student, Course course, int score, MarkTypes type) {
        if (marksToAssign.containsKey(course)) {
        	
        	if(type==MarkTypes.ATT1) student.getMarks().get(course).setFirstAttestation(score);
        	else if (type==MarkTypes.ATT2) student.getMarks().get(course).setSecondAttestation(score);
        	else if (type==MarkTypes.MIDTERM) student.getMarks().get(course).setMidtermPoint(score);
        	else if (type==MarkTypes.ENDTERM) student.getMarks().get(course).setEndtermPoint(score);
        	else if (type==MarkTypes.FINAL) student.getMarks().get(course).setFinalPoint(score);
        	else student.getMarks().get(course).setScore(score);
            
            
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

	public void addLessonToSchedule(Lesson lesson) {
		
    }
	
	public String toString() {
		return super.toString() + " is a teacher";
	}
}
