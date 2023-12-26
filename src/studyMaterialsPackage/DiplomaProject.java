package studyMaterialsPackage;

import java.util.List;
import usersPackage.GraduateStudent;
import researchPackage.*;
/**
 * Diploma project class represents a diploma project of a graduate student
 */
public class DiplomaProject {
	private GraduateStudent student;
	private List<ResearchPaper> publishedPapers;
	
	/**
	 * constructor
	 * @param student student who creates the project
	 * @param publishedPapers
	 */
    public DiplomaProject(GraduateStudent student, List<ResearchPaper> publishedPapers) {
        this.student = student;
        this.publishedPapers = publishedPapers;
    }
    
 
    /**
     * Method to add a research paper to the project
     * @param researchPaper paper that is being added
     */
    public void addResearchPaper(ResearchPaper researchPaper) {
        
		publishedPapers.add(researchPaper);
    }
    
    /**
     * Method to get the student associated with the project
     * @return graduate student object
     */
    public GraduateStudent getStudent() {
        return student;
    }
    
    /**
     * Method to print details of the diploma project
     */
    public void printProjectDetails() {
        System.out.println("Diploma Project Details:");
        System.out.println("Student: " + student.getName());
        System.out.println("Published Papers:");
        for (ResearchPaper paper : publishedPapers) {
            System.out.println("  - " + paper.getTitle());
        }
    }
    
    public String toString() {
    	return "Diploma project made by " + student.toString();
    }
}
