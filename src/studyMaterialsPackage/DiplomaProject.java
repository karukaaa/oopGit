package studyMaterialsPackage;

import java.util.List;
import usersPackage.GraduateStudent;
import researchPackage.*;

public class DiplomaProject {
	private GraduateStudent student;
	private List<ResearchPaper> publishedPapers;
	
	
    public DiplomaProject(GraduateStudent student, List<ResearchPaper> publishedPapers) {
        this.student = student;
        this.publishedPapers = publishedPapers;
    }
    
 // Method to add a research paper to the project
    public void addResearchPaper(ResearchPaper researchPaper) {
        
		publishedPapers.add(researchPaper);
    }
    
    // Method to get the student associated with the project
    public GraduateStudent getStudent() {
        return student;
    }
    
 // Method to print details of the diploma project
    public void printProjectDetails() {
        System.out.println("Diploma Project Details:");
        System.out.println("Student: " + student.getName());
        System.out.println("Published Papers:");
        for (ResearchPaper paper : publishedPapers) {
            System.out.println("  - " + paper.getTitle());
        }
    }
}
