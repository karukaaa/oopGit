package researchPackage;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import usersPackage.*;

public class ResearchJournal {
	String journalName;
	Vector<ResearchPaper> papers;
	Set<User> observers;
	String category;
	{
		papers = new Vector<>();
		observers = new HashSet<>();
	}
	
	public ResearchJournal() {
		
	}
	public ResearchJournal(String journalName) {
		this.journalName = journalName;
	}
	

	public String getJournalName() {
		return journalName;
	}
	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}
	public Vector<ResearchPaper> getPapers() {
		return papers;
	}
	public void setPapers(Vector<ResearchPaper> papers) {
		this.papers = papers;
	}
	
	public Set<User> getObservers() {
		return observers;
	}
	public void setObservers(Set<User> observers) {
		this.observers = observers;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void addObserver(User u) {
		observers.add(u);
	}
	public void removeObserver(User u) {
		observers.remove(u);
	}
	public void notifyObservers() {
		//notifying them
	}
	
	public void addPaper(ResearchPaper paper) {
		papers.add(paper);
	}
	public void removePaper(ResearchPaper paper) {
		papers.remove(paper);
	}
	
	public void printJournal() {
		for(ResearchPaper cur : papers) {
			System.out.println(cur.toString());
		}
	}
}
