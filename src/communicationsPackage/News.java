package communicationsPackage;

import java.time.LocalDate;
import java.util.Vector;
/**
 * News class represents one News
 */
public class News {
	public final NewsTopics topic;
	public String title;
	public String text;
	public LocalDate datePublished;
	public Vector<String> comments = new Vector<>();
	
	{
		datePublished = LocalDate.now();
	}
	
	/**
	 * Default constructor
	 */
	public News() {
		topic = null;
	}
	
	/**
	 * Constructor
	 * @param topic topic of the news
	 * @param title title of the news
	 * @param text text about the news
	 */
	public News(NewsTopics topic, String title, String text) {
		this.topic = topic;
		this.title = title;
		this.text = text;
	}
	
	/**
	 *  method to get title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * method to set title
	 * @param title String title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 *  method to get text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * method to set text of the news
	 * @param text string text
	 */
	public void setText(String text) {
		this.text = text;
	}


	/**
	 * getter for topic
	 * @return topic as NewsTopic literal
	 */
	public NewsTopics getTopic() {
		return topic;
	}
	
	/**
	 * getter for comments vector
	 * @return
	 */
	public Vector<String> getComments() {
		return comments;
	}

	/**
	 * setter for comments
	 * @param comments vector of comments
	 */
	public void setComments(Vector<String> comments) {
		this.comments = comments;
	}

	/**
	 * getter for published date
	 * @return date as LocalDate
	 */
	public LocalDate getDatePublished() {
		return datePublished;
	}

	/**
	 * method to add comments
	 * @param comment text of the comment
	 */
	public void addComment(String comment) {
		comments.add(comment);
	}
	/**
	 * method to remove specific comment
	 * @param comment
	 */
	public void removeComment(String comment) {
		comments.remove(comment);
	}
	
	/**
	 * method to print all comments
	 */
	public void printComments() {
		for(String cur : comments) {
			System.out.println(cur);
		}
	}
	
	/**
	 * toString method that return title and topic of the news
	 */
	public String toString() {
		return this.title + ": " + this.topic;
	}
}
