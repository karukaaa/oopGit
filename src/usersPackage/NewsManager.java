package usersPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

import communicationsPackage.*;
import researchPackage.*;
import studyMaterialsPackage.Faculty;

public class NewsManager extends Manager{
	static List<ResearcherPerson> researchers = new ArrayList<>();
	static List<News> news = new ArrayList<>();
	static List<ResearchJournal> journals = new ArrayList<>();
	static List<ResearchPaper> papers = new ArrayList<>();
	
	public NewsManager(String name) {
		super(name);
	}
	
	
	public static List<News> getNews() {
		return news;
	}
	public static void setNews(List<News> news) {
		NewsManager.news = news;
	}
	

	public static List<ResearchPaper> getPapers() {
		return papers;
	}
	public static void setPapers(List<ResearchPaper> papers) {
		NewsManager.papers = papers;
	}


	public static List<ResearcherPerson> getResearchers() {
		return researchers;
	}
	public static void setResearchers(List<ResearcherPerson> researchers) {
		NewsManager.researchers = researchers;
	}

	public void addResearcher(ResearcherPerson p) {
		researchers.add(p);
	}
	public void removeResearcher(ResearcherPerson p) {
		researchers.remove(p);
	}
	
	public static List<ResearchJournal> getJournals() {
		return journals;
	}
	public static void setJournals(List<ResearchJournal> journals) {
		NewsManager.journals = journals;
	}
	
	public void addNews(News n) {
		if(n.getTopic() == NewsTopics.RESEARCH) news.add(0, n);
		else news.add(n);	
	}
	public void addNews(NewsTopics topic, String title, String text) {
		News newNews = new News(topic, title, text);
		addNews(newNews);
	}
	public void addNews(NewsTopics topic, String title, String text, String comment) {
		News newNews = new News(topic, title, text, comment);
		addNews(newNews);
	}
	
	
	public void removeNews(News n) {
		news.remove(n);
	}
	
	public void printNews() {
		for(News cur: news) {
			System.out.println(cur + " - " + cur.getText());
			if(cur.getComment()!=null) System.out.println(cur.getComment());
		}
	}
	
	
	
	public void addPaper(ResearchPaper p) {
		papers.add(p);
		p.setCitationKey(papers.indexOf(p));
	}
	public void removePaper(ResearchPaper p) {
		papers.remove(p);
	}
	
	
	public void printResearchPaper(Comparator comp) {
		Collections.sort(papers, comp);
		
		for(ResearchPaper cur: papers) {
			System.out.println(cur);
		}
	}

	
	public void topCitedResearcher() {
		Collections.sort(researchers, new ResearcherCitesComparator());
		System.out.println("Most cited researcher: " + researchers.get(0));;
	}
	
	public void topCitedResearcher(Faculty faculty) {
		Collections.sort(researchers, new ResearcherCitesComparator());
		
		Optional<ResearcherPerson> person = researchers.stream().
				filter(researchers->researchers.getFaculty().equals(faculty))
				.findFirst();
		
		if(person.isPresent()) System.out.println("Most cited researcher in "+faculty+" is " + person.get());
		else System.out.println("There are no researchers with citations in "+faculty);
	}
	
	public void topCitedResearcher(int year) {
		Collections.sort(researchers, new ResearcherCitesComparator());
		Optional<ResearcherPerson> person = researchers.stream().
			filter(researchers->researchers.getCites(year)>0).
			findFirst();
		if(person.isPresent()) System.out.println("Most cited researcher in "+year+" is " + person.get());
		else System.out.println("There are no researchers with citations in "+year);
	
	}
	

	public String toString() {
		return super.toString() + " is a news manager";
	}
}
