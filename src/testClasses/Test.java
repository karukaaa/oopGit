package testClasses;

import java.util.Date;

import researchPackage.*;
import usersPackage.*;

public class Test {

	public static void main(String[] args) {

		ResearcherStudent person = new ResearcherStudent(new Student("Aru"));
	
		
		person.addPaper("paper title", "this is a research paper");
		
		person.getPapers().get(0).appendToPage("text on the page 0.", 0);
		
		Date date1 = new Date(122, 10, 1); // November 1, 2022 (Year 122 is 2022)
        Date date2 = new Date(122, 11, 1); // December 1, 2022

        int comparisonResult = date1.compareTo(date2);
        System.out.println(comparisonResult);
		
	}

}
