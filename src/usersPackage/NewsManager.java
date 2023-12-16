package usersPackage;
import java.util.Vector;

import communicationsPackage.*;
import researchPackage.*;

public class NewsManager extends Manager{
	
	static Vector<News> news = new Vector<>();
	static Vector<ResearchJournal> journals = new Vector<>();
	
	public NewsManager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
