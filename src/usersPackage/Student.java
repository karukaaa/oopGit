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
	protected ResearcherPerson research;
	private int totalCredits=0;

/**
 * Constructor that uses builder's parameters as its own parameters	
 * @param builder
 */
	public Student(StudentBuilder builder) {
		this.courses = builder.courses;
        this.marks = builder.marks;
        this.major = builder.major;
        this.level = builder.level;
        this.failedCourses = builder.failedCourses;
        this.lessonSchedule = builder.lessonSchedule;
        this.specialty = builder.specialty;
        this.isResearcher = builder.isResearcher;
        this.research = builder.research;
        this.totalCredits = builder.totalCredits;
	}
	
	
	/**
	 * Gets the major specialty associated with this person.
	 * @return The major specialty.
	 */
	public Specialty getMajor() {
	    return major;
	}

	/**
	 * Sets the major specialty for this person.
	 * @param major The major specialty to set.
	 */
	public void setMajor(Specialty major) {
	    this.major = major;
	}

	/**
	 * Gets the level of this person.
	 * @return The level.
	 */
	public int getLevel() {
	    return level;
	}

	/**
	 * Sets the level for this person.
	 * @param level The level to set.
	 */
	public void setLevel(int level) {
	    this.level = level;
	}

	/**
	 * Gets the count of failed courses for this person.
	 * @return The count of failed courses.
	 */
	public int getFailedCourses() {
	    return failedCourses;
	}

	/**
	 * Sets the count of failed courses for this person.
	 * @param failedCourses The count of failed courses to set.
	 */
	public void setFailedCourses(int failedCourses) {
	    this.failedCourses = failedCourses;
	}

	/**
	 * Gets the lesson schedule for this person.
	 * @return The lesson schedule.
	 */
	public List<Lesson> getLessonSchedule() {
	    return lessonSchedule;
	}

	/**
	 * Sets the lesson schedule for this person.
	 * @param lessonSchedule The lesson schedule to set.
	 */
	public void setLessonSchedule(List<Lesson> lessonSchedule) {
	    this.lessonSchedule = lessonSchedule;
	}

	/**
	 * Gets the specialty associated with this person.
	 * @return The specialty.
	 */
	public Specialty getSpecialty() {
	    return specialty;
	}

	/**
	 * Sets the specialty for this person.
	 * @param specialty The specialty to set.
	 */
	public void setSpecialty(Specialty specialty) {
	    this.specialty = specialty;
	}

	/**
	 * Checks if this person is a researcher.
	 * @return True if the person is a researcher, otherwise false.
	 */
	public boolean isResearcher() {
	    return isResearcher;
	}

	/**
	 * Sets whether this person is a researcher or not.
	 * @param isResearcher True if the person is a researcher, otherwise false.
	 */
	public void setResearcher(boolean isResearcher) {
	    this.isResearcher = isResearcher;
	}

	/**
	 * Sets the list of courses for this person.
	 * @param courses The list of courses to set.
	 */
	public void setCourses(List<Course> courses) {
	    this.courses = courses;
	}

	/**
	 * Sets the marks associated with courses for this person.
	 * @param marks The marks associated with courses.
	 */
	public void setMarks(Map<Course, Mark> marks) {
	    this.marks = marks;
	}

	/**
	 * Gets the marks associated with courses for this person.
	 * @return The marks associated with courses.
	 */
	public Map<Course, Mark> getMarks() {
	    return marks;
	}

	/**
	 * Gets the list of courses associated with this person.
	 * @return The list of courses.
	 */
	public List<Course> getCourses() {
	    return courses;
	}

	@Override
	/**
	 * Compares this User's name with another User's name for sorting purposes.
	 * @param o The User object to compare with.
	 * @return A value less than 0 if this User's name is lexicographically less than the other User's name,
	 *         0 if the names are equal, and a value greater than 0 if this User's name is lexicographically greater.
	 */
	public int compareTo(User o) {
	    return this.name.compareTo(o.getName());
	}

	/**
	 * Records attendance for the student.
	 */
	public void putAttendance() {
	    System.out.println("Putting attendance as a student.");
	}

	/**
	 * Allows the student to join a student organization.
	 */
	public void joinStudentOrganization() {
	    System.out.println("Joining student organization as a student.");
	}

	/**
	 * Registers the student for courses through the ORManager's approval.
	 * @param courses The courses to register for.
	 * @param manager The ORManager responsible for course registration approval.
	 * @param intentionToAttend A boolean indicating the student's intention to attend the courses.
	 */
	public void registerForCourses(Object courses, ORManager manager, boolean intentionToAttend) {
	    manager.approveRegistration(courses, this, intentionToAttend);
	}
      
    /**
     * Prints marks of student
     * in order: course, mark 
     */
    public void checkMarks() {
        System.out.println("Marks for " + name + ":");
        for (Map.Entry<Course, Mark> entry : marks.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            System.out.println(course.getCourseName() + ": " + mark.getScore());
        }
    }
    /**
     * Prints courses of student 
     */
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
    
    /**
     * allows student to enroll in some course
     * @param course
     */
    public void enrollCourse(Course course) {
        courses.add(course);
        marks.put(course, new Mark(course, 0));
    }

    /**
     * allows student to view info about some teacher
     * @param teacher specific teacher
     * @return
     */
    public String viewInfoAboutTeacher(Teacher teacher) {
		String teacherInfo = "Information about the teacher:\n";

		teacherInfo += teacher.toString();

		return teacherInfo;
	}
    
    /**
     * generates a transcript that shows the course, associated mark and credits
     */
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
    
    /**
     * method to return total number of credits
     * iterates through courses and gets their credits
     * @return
     */
    private int calculateTotalCredits() {
        int totalCredits = 0;
        for (Course cur : courses) {
            totalCredits += cur.getCredits();
        }
        return totalCredits;
    }

    /**
     * returns transcript
     * @return type Transcript
     */
    public Transcript getTranscript() {
		if (marks != null) {
			return new Transcript(marks, totalCredits);
		} else {
			System.out.println("No transcript available yet.");
			return null;
		}

	}
    
    /**
     * method checks if student has allowed number of credits
     * @return
     */
    public boolean hasExceededCreditLimit() {
		return totalCredits > 21;
	}

    /**
     * Method to check if the student has exceeded the allowed failed courses
     */
	public boolean hasExceededFailedCoursesLimit() {
		return failedCourses > 3;
	}

	/** method for a student to become researcher
	 *  research field is assigned, isResearcher boolean is set to true
	 */
    public void becomeResearcher() {
    	research = new ResearcherPerson(this);
    	isResearcher = true;
    }
    
    /**
     * gets the ResearcherPerson if a person is researcher
     * if not, return null
     * @return null or ResearcherPerson
     */
    public ResearcherPerson getIsResearcher() {
    	if(isResearcher) return research;
    	else return null;
    }
    
    /**
     * Method to rate teacher
     * @param teacher specific teacher
     * @param rate rating to set
     */
    public void rateTeacher(Teacher teacher, int rate) {
    	if(rate<1 || rate>5) System.out.println("No such rating can be put");
    	else teacher.addRating(rate);
    }
    
    /**
     * toString returns information about student 
     */
	public String toString() {
		return super.toString() + " is a student";
	}
	
	
}
