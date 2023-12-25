package usersPackage;

import java.util.*;

import researchPackage.ResearcherPerson;
import studyMaterialsPackage.*;


public class Student extends User{
	private List<Course> courses = new ArrayList<>();
	private Map<Course, Mark> marks = new HashMap<>();
	private Specialty major;
	private int level;
	private int failedCourses;
	private List<Lesson> lessonSchedule = new ArrayList<>();
	private Specialty specialty;
	private boolean isResearcher;
	private ResearcherPerson research;

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
	
	
	
	public Specialty getMajor() {
		return major;
	}
	public void setMajor(Specialty major) {
		this.major = major;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getFailedCourses() {
		return failedCourses;
	}
	public void setFailedCourses(int failedCourses) {
		this.failedCourses = failedCourses;
	}
	public List<Lesson> getLessonSchedule() {
		return lessonSchedule;
	}
	public void setLessonSchedule(List<Lesson> lessonSchedule) {
		this.lessonSchedule = lessonSchedule;
	}
	
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	public boolean isResearcher() {
		return isResearcher;
	}
	public void setResearcher(boolean isResearcher) {
		this.isResearcher = isResearcher;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public void setMarks(Map<Course, Mark> marks) {
		this.marks = marks;
	}
	public Map<Course, Mark> getMarks() {
		return marks;
	}

	
	public List<Course> getCourses() {
        return courses;
    }
	
	@Override
	public int compareTo(User o) {
		return this.name.compareTo(o.getName());
	}
	
    public void putAttendance() {
        System.out.println("Putting attendance as a student.");
    }

    public void joinStudentOrganization() {
        System.out.println("Joining student organization as a student.");
    }
    
    public void registerForCourses(Object courses, ORManager manager, boolean intentionToAttend) {
        manager.approveRegistration(courses, this, intentionToAttend);
    }
      
    

    public void checkMarks() {
        System.out.println("Marks for " + name + ":");
        for (Map.Entry<Course, Mark> entry : marks.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            System.out.println(course.getCourseName() + ": " + mark.getScore());
        }
    }
    
    public void displayCourses() {
        System.out.print("Student name: " + getName() + " (" + major + ", Courses: ");

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            System.out.print(course.getCourseName() + " - Year " + course.getYearOfStudy());
            if (i < courses.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(")");
    }
    
    public void enrollCourse(Course course) {
        courses.add(course);
        marks.put(course, new Mark(course, 0));
    }


    public void becomeResearcher() {
    	research = new ResearcherPerson(this);
    	isResearcher = true;
    }
    
    public ResearcherPerson getIsResearcher() {
    	if(isResearcher) return research;
    	else return null;
    }
    
	public String toString() {
		return super.toString() + " is a student";
	}
	
	
}
