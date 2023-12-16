package usersPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import communicationsPackage.*;
import researchPackage.*;

public class NewsManager extends Manager{
	
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


	public static List<ResearchJournal> getJournals() {
		return journals;
	}
	public static void setJournals(List<ResearchJournal> journals) {
		NewsManager.journals = journals;
	}
	
	public void addNews(News n) {
		news.add(n);
	}
	public void removeNews(News n) {
		news.remove(n);
	}
	
	public void addPaper(ResearchPaper p) {
		papers.add(p);
	}
	public void removePaper(ResearchPaper p) {
		papers.remove(p);
	}
	
	@SuppressWarnings("unchecked")
	public void printResearchPaper(Comparator comp) {
		Collections.sort(papers, comp);
		
		for(ResearchPaper cur: papers) {
			System.out.println(cur);
		}
	}

	public String toString() {
		return super.toString() + " is a news manager";
	}
}
