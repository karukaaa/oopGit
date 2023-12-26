package testClasses;

import researchPackage.*;
import studyMaterialsPackage.Faculty;
import usersPackage.*;
import communicationsPackage.*;

public class Test {

	public static void main(String[] args) {
        NewsManager nm = new NewsManager("mr Manager");
		Teacher teacher = new Teacher("mr Teacher", TeacherType.TRAINEE);

		ResearcherPerson person1 = new ResearcherPerson("Aru");
		ResearcherPerson person2 = new ResearcherPerson("Ura");

		nm.addResearcher(person1);
		nm.addResearcher(person2);

	
		ResearchPaper paper1 = person1.addPaper("medical research", "this is a med paper", nm);
		ResearchPaper paper2 = person2.addPaper("science paper", "this is a science paper", nm);
		ResearchPaper paper3 = person2.addPaper("oil&gas paper", "article about oil&gas", nm);
		
		paper1.publishPaper();
		paper2.publishPaper();
		paper3.publishPaper();
				
		nm.addNews(NewsTopics.ACADEMIC, "Title1", "text for news");
		nm.addNews(NewsTopics.RESEARCH, "Title2", "text for news");
		nm.addNews(NewsTopics.GENERAL, "Title3", "text for news");
		nm.addNews(NewsTopics.RESEARCH, "Title4", "text for news");
		
		nm.printNews();
		
	}
}
