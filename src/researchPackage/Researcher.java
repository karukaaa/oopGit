package researchPackage;

import java.util.Vector;

public interface Researcher {
	void submitPapers();
	
	void addPaper(String title, String description);
	
	void addPaper(ResearchPaper paper);
	
	void removePaper(ResearchPaper p);
	
	void startProject(String topic, String description);
	
	void printPapers(); //add comparators
	
	int calculateHindex();
	
	public Vector<ResearchProject> getProjects();

	public void setProjects(Vector<ResearchProject> projects);

	public Vector<ResearchPaper> getPapers();

	public void setPapers(Vector<ResearchPaper> papers);
	
	void modifyProject();
}
