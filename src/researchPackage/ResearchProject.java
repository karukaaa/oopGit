package researchPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import usersPackage.User;

public class ResearchProject {
	String topic;
	String description;
	List<ResearchPaper> papers;
	List<ResearcherPerson> participants;
	{
		papers = new ArrayList<>();
		participants = new ArrayList<>();
	}
	
	public ResearchProject() {
		
	}
	public ResearchProject(String topic, String description) {
		this.topic = topic;
		this.description = description;
	}
	
	
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ResearchPaper> getPapers() {
		return papers;
	}
	public void setPapers(List<ResearchPaper> papers) {
		this.papers = papers;
	}
	public List<ResearcherPerson> getParticipants() {
		return participants;
	}
	public void setParticipants(List<ResearcherPerson> participants) {
		this.participants = participants;
	}
	
	
	public void joinProject(User u) {		
		try {
			if(u instanceof ResearcherPerson) 
				participants.add((ResearcherPerson)u);  
			else throw new NotResearcherError("This person isn't a researcher");
		} catch(NotResearcherError e) {
			System.out.println(e);
		}
	}
	
	public void leaveProject(ResearcherPerson r) {
		participants.remove(r);
	}
	
	
	public void addPaper(ResearchPaper p) {
		papers.add(p);
	}
	public void removePaper(ResearchPaper p) {
		papers.remove(p);
	}
	
	public String toString() {
		return "Research project: " + topic + " " + description;
	}
}
