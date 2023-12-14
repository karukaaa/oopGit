package researchPackage;

import java.util.Vector;

public class ResearchProject {
	String topic;
	String description;
	Vector<ResearchPaper> papers;
	Vector<Researcher> participants;
	{
		papers = new Vector<>();
		participants = new Vector<>();
	}
	
	public ResearchProject() {
		
	}
	public ResearchProject(String topic, String description) {
		this.topic = topic;
		this.description = description;
	}
	
	public void joinProject(Researcher r) {
		participants.add(r);
	}
	public void leaveProject(Researcher r) {
		participants.remove(r);
	}
	
	public void addPaper(ResearchPaper p) {
		papers.add(p);
	}
	public void removePaper(ResearchPaper p) {
		papers.remove(p);
	}
}
