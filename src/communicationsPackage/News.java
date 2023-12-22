package communicationsPackage;

import java.time.LocalDate;

public class News {
	public final NewsTopics topic;
	public String title;
	public String text;
	public String comment;
	public LocalDate datePublished;
	
	{
		datePublished = LocalDate.now();
	}
	
	public News() {
		topic = null;
	}
	
	public News(NewsTopics topic, String title, String text) {
		this.topic = topic;
		this.title = title;
		this.text = text;
	}
	public News(NewsTopics topic, String title, String text, String comment) {
		this(topic, title, text);
		this.comment = comment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public NewsTopics getTopic() {
		return topic;
	}
	
	
	public LocalDate getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(LocalDate datePublished) {
		this.datePublished = datePublished;
	}

	public String toString() {
		return this.title + ": " + this.topic;
	}
}
