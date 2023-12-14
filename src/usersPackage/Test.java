package usersPackage;

import researchPackage.*;

public class Test {

	public static void main(String[] args) {

//		System.out.println(s.isResearcher());
		
		ResearcherStudent person = new ResearcherStudent(new Student("Aru"));
		

		
//		ResearcherEmployee r = new ResearcherEmployee();
//		System.out.println(r.toString());
		
		person.addPaper("paper title", "this is a research paper");
		
		person.getPapers().get(0).appendToPage("text on the page 0.", 0);
		person.getPapers().get(0).appendToPage(" addition to page 0.", 0);
		System.out.println(person.getPapers().get(0).getTextFromPage(0));
//		System.out.println(person.isResearcher());
		
	}

}
