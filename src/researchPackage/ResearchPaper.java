package researchPackage;

import java.util.Date;
import java.util.Vector;
import usersPackage.*;

public class ResearchPaper {
	String title;
	String description;
	Vector<Researcher> authors;
	Vector<ResearchJournal> journals;
	Vector<String> text; // each entry is a page
	int pages;
	Date datePublished;
	String citationFormat;
	int citations;
	public NewsManager manager;
	
	{
		authors = new Vector<>();
		journals = new Vector<>();
		text = new Vector<>();
		citations = 0;
	}
	
	public ResearchPaper(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public void publishPaper(ResearchPaper p) {
		manager.addPaper(p);
		datePublished = new Date();
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Vector<Researcher> getAuthors() {
		return authors;
	}
	public void setAuthors(Vector<Researcher> authors) {
		this.authors = authors;
	}
	
	public Vector<ResearchJournal> getJournals() {
		return journals;
	}
	public void setJournals(Vector<ResearchJournal> journals) {
		this.journals = journals;
	}

	public Vector<String> getText() {
		return text;
	}
	public void setText(Vector<String> text) {
		this.text = text;
	}

	public int getPages() {
		return pages;
	}
	
	public String getTextFromPage(int page) {
		if(page>=text.size()) {
			System.out.println("Page " + page + " doesn't exist");
			return null;
		}
		return text.get(page);
	}

	public Date getDatePublished() {
		return datePublished;
	}

	public int getCitations() {
		return citations;
	}

	public void appendToPage(String newEntry, int page) {
		
		if(page < text.size()) {
			String currentString = text.get(page);
			if(currentString != null) {
				text.set(page, currentString + newEntry);
			}else {
				text.set(page, newEntry);
			}
		}else {
			System.out.println("Page out of bounds, adding another page");
			text.add(newEntry);
		}
	}
	
	public void editPage(String newEntry, int page) {
		text.set(page, newEntry);
	}
	
	public String getCitation(CitationFormat f) {
		//implement citation logic
		return " ";
	}
	

	public String toString(){
		return title + " " + description + datePublished;
	}
	
}
