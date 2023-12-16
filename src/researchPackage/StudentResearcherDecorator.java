package researchPackage;

import java.util.Vector;

import usersPackage.*;

public abstract class StudentResearcherDecorator extends Student implements Researcher{
	Researcher subject;
	
	public StudentResearcherDecorator(Researcher newResearcher) {
		subject = newResearcher;
	}

	@Override
	public void submitPapers() {
		subject.submitPapers();
	}

	@Override
	public void startProject(String topic, String description) {
		subject.startProject(topic, description);
		
	}

	@Override
	public void printPapers() {
		subject.printPapers();
	}

	@Override
	public int calculateHindex() {
		return subject.calculateHindex();
	}

	@Override
	public void modifyProject() {
		subject.modifyProject();
	}


	@Override
	public void removePaper(ResearchPaper p) {
		subject.removePaper(p);
	}

	@Override
	public ResearchPaper addPaper(String title, String description) {
		return subject.addPaper(title, description);
	}
	
	public Vector<ResearchProject> getProjects() {
		return subject.getProjects();
	}

	public void setProjects(Vector<ResearchProject> projects) {
		subject.setProjects(projects);
	}

	public Vector<ResearchPaper> getPapers() {
		return subject.getPapers();
	}

	public void setPapers(Vector<ResearchPaper> papers) {
		subject.setPapers(papers);
	}
	
	public String toString() {
		return subject.toString();
	}

}
