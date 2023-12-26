package usersPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import communicationsPackage.*;
import researchPackage.*;
import studyMaterialsPackage.Faculty;


public class NewsManager extends Manager {

    static List<ResearcherPerson> researchers = new ArrayList<>();
    static List<News> news = new ArrayList<>();
    static List<ResearchJournal> journals = new ArrayList<>();
    static List<ResearchPaper> papers = new ArrayList<>();
    /**
     * The NewsManager class represents a manager responsible for managing news, researchers, and research papers.
     * It extends the Manager class.
     */
   
    public NewsManager(String name) {
        super(name, ManagerType.NEWS_MANAGER); 
        /**
         * Constructs a NewsManager with the specified name.
        *
        * @param name The name of the NewsManager.
        */
    }

   
    public static List<News> getNews() {
        return news;
        /**
         * Gets the list of news managed by the NewsManager.
         *
         * @return The list of news.
         */
    }

        public static void setNews(List<News> news) {
        NewsManager.news = news;
        /**
         * Sets the list of news managed by the NewsManager.
         *
         * @param news The list of news to set.
         */
    }
    
    public static List<ResearchPaper> getPapers() {
        return papers;
        /**
         * Gets the list of research papers managed by the NewsManager.
         *
         * @return The list of research papers.
         */
    }

    public static void setPapers(List<ResearchPaper> papers) {
        NewsManager.papers = papers;
        /**
         * Sets the list of research papers managed by the NewsManager.
         *
         * @param papers The list of research papers to set.
         */
    }
   
    public static List<ResearcherPerson> getResearchers() {
        return researchers;
        /**
         * Gets the list of researchers managed by the NewsManager.
         *
         * @return The list of researchers.
         */
    }

    public static void setResearchers(List<ResearcherPerson> researchers) {
        NewsManager.researchers = researchers;
        /**
         * Sets the list of researchers managed by the NewsManager.
         *
         * @param researchers The list of researchers to set.
         */
    }
   
    public void addResearcher(ResearcherPerson p) {
        researchers.add(p);
        /**
         * Adds a researcher to the list of researchers.
         *
         * @param p The researcher to add.
         */
    }

    public void removeResearcher(ResearcherPerson p) {
        researchers.remove(p);
        /**
         * Removes a researcher from the list of researchers.
         *
         * @param p The researcher to remove.
         */
    }

  
    public static List<ResearchJournal> getJournals() {
        return journals;
        /**
         * Gets the list of research journals managed by the NewsManager.
         *
         * @return The list of research journals.
         */
    }

   
    public static void setJournals(List<ResearchJournal> journals) {
        NewsManager.journals = journals;
        /**
         * Sets the list of research journals managed by the NewsManager.
         *
         * @param journals The list of research journals to set.
         */
    }

        public void addNews(News n) {
        if (n.getTopic() == NewsTopics.RESEARCH) news.add(0, n);
        else news.add(n);
        /**
         * Adds a news item to the list of news.
         *
         * @param n The news item to add.
         */
    }

    
    public void addNews(NewsTopics topic, String title, String text) {
        News newNews = new News(topic, title, text);
        addNews(newNews);
        /**
         * Adds a news item to the list of news with the specified topic, title, and text.
         *
         * @param topic The topic of the news.
         * @param title The title of the news.
         * @param text  The text of the news.
         */
    }

    /**
     * Adds a news item to the list of news with the specified topic, title, text, and comment.
     *
     * @param topic   The topic of the news.
     * @param title   The title of the news.
     * @param text    The text of the news.
     * @param comment The comment on the news.
     */
    public void addNews(NewsTopics topic, String title, String text, String comment) {
        News newNews = new News(topic, title, text, comment);
        addNews(newNews);
    }

    /**
     * Removes a news item from the list of news.
     *
     * @param n The news item to remove.
     */
    public void removeNews(News n) {
        news.remove(n);
    }

    /**
     * Prints the list of news along with their text and comments.
     */
    public void printNews() {
        for (News cur : news) {
            System.out.println(cur + " - " + cur.getText());
            if (cur.getComment() != null) System.out.println(cur.getComment());
        }
    }

    /**
     * Adds a research paper to the list of research papers.
     *
     * @param p The research paper to add.
     */
    public void addPaper(ResearchPaper p) {
        papers.add(p);
        p.setCitationKey(papers.indexOf(p));
    }

    /**
     * Removes a research paper from the list of research papers.
     *
     * @param p The research paper to remove.
     */
    public void removePaper(ResearchPaper p) {
        papers.remove(p);
    }

    /**
     * Prints the list of research papers based on the specified comparator.
     *
     * @param comp The comparator used for sorting the research papers.
     */
    public void printResearchPaper(Comparator comp) {
        Collections.sort(papers, comp);

        for (ResearchPaper cur : papers) {
            System.out.println(cur);
        }
    }

    /**
     * Prints the most cited researcher.
     */
    public void topCitedResearcher() {
        Collections.sort(researchers, new ResearcherCitesComparator());
        System.out.println("Most cited researcher: " + researchers.get(0));
    }

    /**
     * Prints the most cited researcher in the specified faculty.
     *
     * @param faculty The faculty for which to find the most cited researcher.
     */
    public void topCitedResearcher(Faculty faculty) {
        Collections.sort(researchers, new ResearcherCitesComparator());

        Optional<ResearcherPerson> person = researchers.stream()
                .filter(researcher -> researcher.getFaculty().equals(faculty))
                .findFirst();

        if (person.isPresent()) System.out.println("Most cited researcher in " + faculty + " is " + person.get());
        else System.out.println("There are no researchers with citations in " + faculty);
    }

    /**
     * Prints the most cited researcher in the specified year.
     *
     * @param year The year for which to find the most cited researcher.
     */
    public void topCitedResearcher(int year) {
        Collections.sort(researchers, new ResearcherCitesComparator());

        Optional<ResearcherPerson> person = researchers.stream()
                .filter(researcher -> researcher.getCites(year) > 0)
                .findFirst();

        if (person.isPresent()) System.out.println("Most cited researcher in " + year + " is " + person.get());
        else System.out.println("There are no researchers with citations in " + year);
    }


    /**
     * Returns a string representation of the NewsManager.
    *
    * @return A string representation of the NewsManager indicating its type.
    */
    public String toString() {
        return super.toString() + " is a news manager"; 
    }

	@Override
	public void viewAcademicInfo() {
		System.out.println("You can't view academic info");
	}
}