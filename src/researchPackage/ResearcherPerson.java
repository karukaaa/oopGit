package researchPackage;

import java.util.*;

import studyMaterialsPackage.Faculty;
import usersPackage.*;

/**
 * ResearcherPerson class represents a researcher with all its functionality, 
 * if other objects can become researchers, this object ads functionality
 */
public class ResearcherPerson extends User{
	List<ResearchProject> projects;
	List<ResearchPaper> papers;
	List<ResearchPaper> publishedPapers;
	Faculty faculty;
	
	/**
	 * this field is not null if this object represents a teacher
	 */
	public final Teacher subjectTeacher;
	/**
	 * this field is not null if this object represents a student
	 */
	public final Student subjectStudent;
	/**
	 * this field is not null if this object represents a graduate student
	 */
	public final GraduateStudent subjectGraduateStudent;
	
	{
		projects = new ArrayList<>();
		papers = new ArrayList<>();
		publishedPapers = new ArrayList<>();
	}	
	/**
	 * constructor for when a simple employee is assigned as a researcher
	 * @param name name of the employee
	 */
	public ResearcherPerson(String name) {	
		super(name);
		subjectTeacher = null;
		subjectStudent = null;
		subjectGraduateStudent = null;
	}
	/**
	 * constructor for when a student is assigned as a researcher
	 * @param subject student who is being assigned
	 */
	public ResearcherPerson(Student subject) {	
		subjectTeacher = null;
		subjectGraduateStudent = null;
		subjectStudent = subject;	
//		this.faculty = subject.getFaculty(); -add when student is completed full
	}
	
	/**
	 * constructor for when a teacher is assigned as a researcher
	 * @param subject teacher who is being assigned
	 */
	public ResearcherPerson(Teacher subject) {	
		subjectTeacher = subject;
		subjectStudent = null;	
		subjectGraduateStudent = null;
	}
	/**
	 * constructor for when a graduate student is assigned as a researcher
	 * @param subject graduate student who is being assigned
	 */
	public ResearcherPerson(GraduateStudent subject) {	
		subjectTeacher = null;
		subjectStudent = null;	
		subjectGraduateStudent = subject;
	}
	
	/**
	 * getter of the person who is a researcher
	 * @return returns type User
	 */
	public User getSubject() {
		if(subjectTeacher!=null) {
			System.out.println(subjectTeacher.toString());
			return subjectTeacher;
		}
		if(subjectStudent!=null) {
			System.out.println(subjectStudent.toString());
			return subjectStudent;
		}
		if(subjectGraduateStudent!=null) {
			System.out.println(subjectGraduateStudent.toString());
			return subjectGraduateStudent;
		}
		System.out.println((User)this);
		return (User) this;
	}

	/**
	 * getter for subjectTeacher
	 * @return return type Teacher
	 */
	public Teacher getTeacher() {
		return subjectTeacher;
	}
	/**
	 * getter for subjectStudent
	 * @return return type Student
	 */
	public Student getStudent() {
		return subjectStudent;
	}
	/**
	 * getter for subjectGraduateStudent
	 * @return return type GraduateStudent
	 */
	public GraduateStudent getGraduateStudent() {
		return subjectGraduateStudent;
	}
	/**
	 * getter return faculty of this researcher 
	 * @return type Faculty
	 */
	public Faculty getFaculty() {
		return faculty;
	}
	/**
	 * setter of the faculty for this researcher
	 * @param faculty type Faculty
	 */
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	/**
	 * getter of research projects
	 * @return list of projects
	 */
	public List<ResearchProject> getProjects() {
		return projects;
	}
	/**
	 * setter of projects
	 * @param projects list of projects
	 */
	public void setProjects(List<ResearchProject> projects) {
		this.projects = projects;
	}

	/**
	 * getter for research papers
	 * @return list of research papers
	 */
	public List<ResearchPaper> getPapers() {
		return papers;
	}
	/**
	 * setter for papers
	 * @param papers list of research papers
	 */
	public void setPapers(List<ResearchPaper> papers) {
		this.papers = papers;
	}
	
	/**
	 * creates and adds a new research paper
	 * @param title String title
	 * @param description String description
	 * @param manager type NewsManager
	 * @return newly created paper
	 */
	public ResearchPaper addPaper(String title, String description, NewsManager manager) {
		ResearchPaper newPaper = new ResearchPaper(title, description);
		papers.add(newPaper);
		newPaper.authors.add(this);
		
		newPaper.setManager(manager);
		return newPaper;
	}
	/**
	 * removes paper from the list
	 * @param p specific paper that should be removed
	 */
	public void removePaper(ResearchPaper p) {
		papers.remove(p);
	}
	
	/**
	 * adds existing paper
	 * @param paper
	 */
	public void addPaper(ResearchPaper paper) {
		papers.add(paper);
	}
	
	
	/**
	 * getter of published papers
	 * @return
	 */
	public List<ResearchPaper> getPublishedPapers() {
		return publishedPapers;
	}
	/**
	 * setter of published papers
	 * @param publishedPapers
	 */
	public void setPublishedPapers(List<ResearchPaper> publishedPapers) {
		this.publishedPapers = publishedPapers;
	}
	/**
	 * add some paper to the list of published papers
	 * @param p
	 */
	public void addPublishedPaper(ResearchPaper p) {
		publishedPapers.add(p);
	}
	/**
	 * remove some paper from the list of published papers
	 * @param p
	 */
	public void removePublishedPaper(ResearchPaper p) {
		publishedPapers.remove(p);
	}
	
	/**
	 * start a new research project
	 * @param topic topic of the project of type String
	 * @param description description of the project of type String
	 */
	public void startProject(String topic, String description) {
		ResearchProject project = new ResearchProject(topic, description);
		project.joinProject(this);
		projects.add(project);
	}
	
	/**
	 * method to calculate h index and return it as int type
	 * @return h index of type int
	 */
	public int calculateHindex() {
		if (papers.isEmpty()) return 0;

        int[] citationsArray = new int[papers.size()];

        int i = 0;
        for (ResearchPaper p : papers) {
            citationsArray[i] = p.getCitations();
            i++;
        }

        Arrays.sort(citationsArray);

        int hIndex = 0;
        int n = citationsArray.length;
        
        for (int j = n - 1; j >= 0; j--) {
            int citations = citationsArray[j];
            int papersWithCitations = n - j;

            if (citations >= papersWithCitations) {
                hIndex = papersWithCitations;
            } else {
                break;
            }
        }
        return hIndex;
	}



	/**
	 * prints papers in a sorted order dictated by comparator
	 * @param c comparator of papers order
	 */
	public void printPapers(Comparator c) {
		Collections.sort(papers, c);
		for(ResearchPaper cur: papers) {
			System.out.println(cur);
		}
	}
	
	/**
	 * getter for citations of researcher, iterates through all the papers
	 * and gets their citations
	 * @return
	 */
	public int getCites() {
		int cites=0;
		for(ResearchPaper cur : papers) {
			cites+=cur.getCitations();
		}
		return cites;
	}
	/**
	 * getter for citations of a paper published in a specific year
	 * @param year
	 * @return
	 */
	public int getCites(int year) {
		int cites = 0;
		for(ResearchPaper cur : papers) {
			if(cur.getDatePublished().getYear()==year)
			cites+=cur.getCitations();
		}
		return cites;
	}


	/**
	 * comparator method returns super's method
	 */
	@Override
	public int compareTo(User o) {		
		return super.compareTo(o);
	}
	
	/**
	 * toString method returns information about a subject
	 */
	public String toString() {	
		if(subjectTeacher!=null) return super.toString() + " " +subjectTeacher.toString() + " researcher";
		if(subjectStudent!=null) return super.toString() + " " +subjectStudent.toString() + " researcher";
		if(subjectGraduateStudent!=null) return super.toString() + " " +subjectGraduateStudent.toString();
		else return super.toString() + " researcher";	
	}
	
}
