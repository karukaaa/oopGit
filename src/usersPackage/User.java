package usersPackage;

import java.util.Vector;
import researchPackage.*;

public abstract class User implements Comparable<User>{
	public int id;
	public String name;
	public String lastName;
	private int password;
	public Languages language;
	public Vector<ResearchJournal> subscriptions;
	
	//getters for subscriptions
	
	//check how to make id final
	
	{
		language = Languages.EN;
		subscriptions = new Vector<>();
	}
	
	public User() {
		
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPassword(String oldPassword, String newPassword) {
		if(oldPassword.hashCode() != password) {
			System.out.println("Incorrect old password");
			return;
		}
		
		password = newPassword.hashCode();
	}
	
	public void setLanguage(Languages language) {
		this.language = language;
	}
	
	public void subscribeToJournal(ResearchJournal r) {
		//subscription to a journal
	}
	public void unsubscribeToJournal(ResearchJournal r) {
		//unsubscription to a journal
	}
	
	public boolean equals(User o) {
		if(this==o) return true;
		return id == o.getId();
	}
	
	public String toString() {
		return id + " " + name + " " + lastName;
	}
}
