package usersPackage;
import java.util.*;

import communicationsPackage.*;
import researchPackage.ResearcherPerson;
import studyMaterialsPackage.*;


public class Teacher extends Employee{
	private List<Course> courses = new ArrayList<>();
    private Map<Course, Integer> marksToAssign = new HashMap<>();
    public Vector<String> requests = new Vector<>();
    public Vector<UrgencyComplaint> urgencyComplaints = new Vector<>();
    public Vector<Message> messages = new Vector<>();
    private TeacherType type;
    private List<Lesson> lessons = new ArrayList<>();
    private boolean isResearcher;
    private ResearcherPerson research;
    private double rating;
    private int rateTimes=0;
    
    public Teacher() {
    	super();
    }

    
    public Teacher(String name, TeacherType type) {
    	super(name);
    	this.type = type;
    	if(type.equals(TeacherType.PROFESSOR)) {
    		isResearcher = true;
    		research = new ResearcherPerson(this);
    	}
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
    
    public TeacherType getType() {
        return type;
    }

    public void assignCourse(Course course) {
        marksToAssign.put(course, 0);
        System.out.println("You are now assigned to teach " + course.getCourseName());
    }
    
    
    public void addLessonToSchedule(Lesson lesson) {
        lessons.add(lesson);
    }
    

    public void viewEnrolledStudents() {
        System.out.println("Viewing enrolled students as a teacher.");
    }

	@Override
	public int compareTo(User o) {
		return super.compareTo(o);
	}

	public void displayType() {
        System.out.println("Teacher: " + getName() + ", Type: " + getType());
    }
	
	public void becomeResearcher() {
    	research = new ResearcherPerson(this);
    	isResearcher = true;
    }
    
    public ResearcherPerson getIsResearcher() {
    	if(isResearcher) return research;
    	else return null;
    }
    
    public void addRating(int rating) {
		rateTimes++;
		rating+=rating;
	}
    public double getRating() {
    	return rating/rateTimes;
    }
	
	public String toString() {
		return super.toString() + " is a teacher";
	}
}
