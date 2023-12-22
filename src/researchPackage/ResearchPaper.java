package researchPackage;

import java.time.LocalDate;
import java.util.UUID;
import java.util.Vector;
import usersPackage.*;

public class ResearchPaper {
	String title;
	String description;
	Vector<ResearcherPerson> authors = new Vector<>();;
	Vector<ResearchJournal> journals = new Vector<>();;
	Vector<String> text = new Vector<>();; // each entry is a page
	LocalDate datePublished;
	int citations = 0;
	NewsManager manager;
	final String doi;
	int citationKey;
	
	{
		UUID uuid = UUID.randomUUID();
		doi = "10.1/" + uuid.toString();
	}

	public ResearchPaper(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public void publishPaper() {
		manager.addPaper(this);
		datePublished = LocalDate.now();
		System.out.println(title + " was published");
		
		for(ResearcherPerson cur : authors) {
			cur.addPublishedPaper(this);
		}
	}
	
	public void setManager(NewsManager manager) {
		this.manager = manager;
	}
	public NewsManager getManager() {
		return manager;
	}
	
	public int getCitationKey() {
		return citationKey;
	}
	public void setCitationKey(int key) {
		citationKey = key;
	}
	
	public String getDoi() {
		return doi;
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

	public Vector<ResearcherPerson> getAuthors() {
		return authors;
	}
	public void setAuthors(Vector<ResearcherPerson> authors) {
		this.authors = authors;
	}
	public void addAuthor(ResearcherPerson r) {
		authors.add(r);
		r.addPaper(this);
	}
	public void removeAuthor(ResearcherPerson r) {
		authors.remove(r);
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
	
	public String getTextFromPage(int page) {
		if(page>=text.size()) {
			System.out.println("Page " + page + " doesn't exist");
			return null;
		}
		return text.get(page);
	}

	public LocalDate getDatePublished() {
		return datePublished;
	}

	public int getCitations() {
		return citations;
	}
	
	public String getCitation(CitationFormat f, int pageStart, int pageFinish) {
		
		String authorsNames = "";
		for(ResearcherPerson r : authors) {
			authorsNames +=((User)r).getName()+" ";
		}
		int year = datePublished.getYear();
		
		if(f==CitationFormat.BIBTEX) {	
			String cite = String.format("@article{%d, \n"
					+ "author/s = {%s},\n"
					+ "title = {%s},\n"
					+ "year = {%d},\n"
					+ "pages = {%d-%d},\n"
					+ "doi = {%s}}", citationKey, authorsNames, title, year, pageStart, pageFinish, doi);
			return cite;
			
		}else {
			String cite = String.format("%s\"%s\", %d, pp. %d-%d, doi: %s", 
					authorsNames, title, year, pageStart, pageFinish, doi);
			return cite;
		}
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


	public String toString(){
		return title + " " + description + " " + datePublished;
	}
	
}

