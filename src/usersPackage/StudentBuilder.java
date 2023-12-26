package usersPackage;

import java.util.*;
import researchPackage.ResearcherPerson;
import studyMaterialsPackage.*;

/** 
 * StudentBuilder class is a Builder pattern, helps to create new instances of Student
 */
public class StudentBuilder extends User{
	
	public List<Course> courses = new ArrayList<>();
    public Map<Course, Mark> marks = new HashMap<>();
    public Specialty major;
    public int level;
    public int failedCourses = 0;
    public List<Lesson> lessonSchedule = new ArrayList<>();
    public Specialty specialty;
    public boolean isResearcher;
    public ResearcherPerson research;
    public int totalCredits = 0;
    
    /**
     * Constructs a StudentBuilder with the name and student ID.
     * @param name The name of the student.
     * @param studentId The ID of the student.
     */
    public StudentBuilder(String name, int studentId) {
        this.name = name;
        this.id = studentId;
    }

    /**
     * Constructs a StudentBuilder with specific attributes.
     * @param studentId The ID of the student.
     * @param major The major specialty of the student.
     * @param name The name of the student.
     * @param level The level of the student.
     */
    public StudentBuilder(int studentId, Specialty major, String name, int level) {
        this.id = studentId;
        this.major = major;
        this.name = name;
        this.level = level;
    }

	public StudentBuilder setCourses(List<Course> courses) {
		this.courses = courses;
		return this;
	}

	public StudentBuilder setMarks(Map<Course, Mark> marks) {
		this.marks = marks;
		return this;
	}

	public StudentBuilder setMajor(Specialty major) {
		this.major = major;
		return this;
	}

	public StudentBuilder setLevel(int level) {
		this.level = level;
		return this;
	}

	public StudentBuilder setFailedCourses(int failedCourses) {
		this.failedCourses = failedCourses;
		return this;
	}

	public StudentBuilder setLessonSchedule(List<Lesson> lessonSchedule) {
		this.lessonSchedule = lessonSchedule;
		return this;
	}

	public StudentBuilder setSpecialty(Specialty specialty) {
		this.specialty = specialty;
		return this;
	}

	public StudentBuilder setResearcher(boolean isResearcher) {
		this.isResearcher = isResearcher;
		return this;
	}

	public StudentBuilder setResearch(ResearcherPerson research) {
		this.research = research;
		return this;
	}

	public StudentBuilder setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
		return this;
	}
	
}
