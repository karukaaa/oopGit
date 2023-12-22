package usersPackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import researchPackage.*;
import studyMaterialsPackage.*;

public class Student extends User{
	
	private List<Course> courses = new ArrayList<>();
	private Map<Course, Mark> marks = new HashMap<>();
	private Specialty major;

	public Student() {
		
	}
	public Student(String name) {
		super(name);
	}
	public Student(String name,String lastName) {
		super(name, lastName);
	}
	public Student(String name, Specialty major) {
		super(name);
		this.major = major;
	}
	
	
	public Map<Course, Mark> getMarks() {
		return marks;
	}

	
	public List<Course> getCourses() {
        return courses;
    }
	
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public void viewCourses() {
        System.out.println("Viewing available courses as a student.");
    }

    public void viewMarkDetails() {
        System.out.println("Viewing mark details as a student.");
    }

    public void putAttendance() {
        System.out.println("Putting attendance as a student.");
    }

    public void joinStudentOrganization() {
        System.out.println("Joining student organization as a student.");
    }

    public void seeNews() {
        System.out.println("Viewing news as a student.");
    }


    public void checkMarks() {
        System.out.println("Marks for " + name + ":");
        for (Map.Entry<Course, Mark> entry : marks.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            System.out.println(course.getCourseName() + ": " + mark.getScore());
        }
    }
    
    public void approveRegistration(List<Course> approvedCourses) {
        for (Course course : approvedCourses) {
            enrollCourse(course);
        }
    }
    
    public void enrollCourse(Course course) {
        courses.add(course);
        marks.put(course, new Mark(course, 0));
    }

	

	public String toString() {
		return super.toString() + " is a student";
	}
	
	
}
