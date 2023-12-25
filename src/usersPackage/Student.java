package usersPackage;

import java.util.*;
import java.util.Map.Entry;

import researchPackage.ResearcherPerson;
import studyMaterialsPackage.*;


public class Student extends User{
	private List<Course> courses = new ArrayList<>();
	private Map<Course, Mark> marks = new HashMap<>();
	private Specialty major;
	private int level;
	private int failedCourses=0;
	private List<Lesson> lessonSchedule = new ArrayList<>();
	private Specialty specialty;
	private boolean isResearcher;
	private ResearcherPerson research;
	private int totalCredits=0;

	public Student() {
		
	}
	public Student(String name) {
		super(name);
	}
	public Student(String name, String lastName) {
		super(name, lastName);
	}
	public Student(String name, Specialty major) {
		super(name);
		this.major = major;
	}
	
	public Student(int studentId, Specialty major, String name, int level) {
		super();
		this.id = studentId;
		this.major = major;
		this.name = name;
		this.level = level;
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

    
    public String viewInfoAboutTeacher(Teacher teacher) {
		String teacherInfo = "Information about the teacher:\n";

		teacherInfo += teacher.toString();

		return teacherInfo;
	}
    
    public void viewTranscript() {
        if (marks != null && !marks.isEmpty()) {
            System.out.println("Transcript:");

            for (Entry<Course, Mark> entry : marks.entrySet()) {
                Course course = entry.getKey();
                Mark mark = entry.getValue();
                System.out.println("Course: " + course + " " + mark.getFirstAttestation() + " " + mark.getSecondAttestation() + " " + mark.getFinalPoint());
            }

            System.out.println("Total Credits: " + calculateTotalCredits());
        } else {
            System.out.println("No transcript available yet.");
        }
    }

    private int calculateTotalCredits() {
        int totalCredits = 0;
        for (Course cur : courses) {
            totalCredits += cur.getCredits();
        }
        return totalCredits;
    }

    public Transcript getTranscript() {
		if (marks != null) {
			return new Transcript(marks, totalCredits);
		} else {
			System.out.println("No transcript available yet.");
			return null;
		}

	}
    
    public boolean hasExceededCreditLimit() {
		return totalCredits > 21;
	}

	// Method to check if the student has exceeded the allowed failed courses
	public boolean hasExceededFailedCoursesLimit() {
		return failedCourses > 3;
	}

    public void becomeResearcher() {
    	research = new ResearcherPerson(this);
    	isResearcher = true;
    }
    
    public ResearcherPerson getIsResearcher() {
    	if(isResearcher) return research;
    	else return null;
    }
    
    public void rateTeacher(Teacher teacher, int rate) {
    	if(rate<1 || rate>5) System.out.println("No such rating can be put");
    	else teacher.addRating(rate);
    }
    
	public String toString() {
		return super.toString() + " is a student";
	}
	
	
}
