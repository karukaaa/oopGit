package usersPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import researchPackage.*;
import studyMaterialsPackage.*;


public class Student extends User implements Researcher{
	
	private Map<Course, Mark> marks = new HashMap<>();
	boolean isResearcher = false;

	public Student() {
		
	}
	public Student(String name) {
		super(name);
	}
	public Student(String name,String lastName) {
		super(name, lastName);
	}
	
	public void becomingResearcher() {
		System.out.println(name + " is not yet a researcher");
		//implement logic to become researcher
	}
	
	
	@Override
	public void submitPapers() {
		System.out.println();
	}

	@Override
	public void startProject(String topic, String description) {
		if(!isResearcher) becomingResearcher();
		
	}

	@Override
	public void printPapers() {
		if(!isResearcher) becomingResearcher();
	}

	@Override
	public int calculateHindex() {
		if(!isResearcher) becomingResearcher();
		return 0;
	}

	@Override
	public void modifyProject() {
		if(!isResearcher) becomingResearcher();
	}

	@Override
	public void addPaper(String title, String description) {
		if(!isResearcher) becomingResearcher();
	}

	@Override
	public void removePaper(ResearchPaper p) {
		if(!isResearcher) becomingResearcher();
	}
	public Vector<ResearchProject> getProjects() {
		if(!isResearcher) becomingResearcher();
		return null;
	}

	public void setProjects(Vector<ResearchProject> projects) {
		if(!isResearcher) becomingResearcher();
	}

	public Vector<ResearchPaper> getPapers() {
		if(!isResearcher) becomingResearcher();
		return null;
	}

	public void setPapers(Vector<ResearchPaper> papers) {
		if(!isResearcher) becomingResearcher();
	}
	
	public boolean isResearcher() {
		return isResearcher;
	}

	public void setResearcher(boolean isResearcher) {
		this.isResearcher = isResearcher;
	}
	
	@Override
	public void addPaper(ResearchPaper paper) {
		if(!isResearcher) becomingResearcher();
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

    public void receiveMark(Mark mark) {
        marks.put(mark.getCourse(), mark);
    }

    public void checkMarks() {
        System.out.println("Marks for " + name + ":");
        for (Map.Entry<Course, Mark> entry : marks.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            System.out.println(course.getCourseName() + ": " + mark.getScore());
        }
    }
	

	public String toString() {
		return super.toString() + " is a student";
	}
	
}
