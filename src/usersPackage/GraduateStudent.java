package usersPackage;

import java.util.*;

import researchPackage.*;

public class GraduateStudent extends Student{
	
	ResearcherPerson supervisor;
	ResearcherPerson research;
	
	{
		research = new ResearcherPerson(this);
	}
	
	public GraduateStudent() {
		
	}
	
	
	public GraduateStudent(String name) {
		super(name);
	}
	
	public ResearcherPerson getResearch() {
		return research;
	}
	public void setResearch(ResearcherPerson research) {
		this.research = research;
	}


	public void setSupervisor(ResearcherPerson supervisor) {
		try {
			if (supervisor.calculateHindex()<3) throw new IncorrectSupervisorError("This researcher has h index less than 3");
		} catch(IncorrectSupervisorError e) {
			System.out.println(e);
		}
	}
	public ResearcherPerson getSupervisor() {
		return supervisor;
	}
	

	public String toString() {
		return super.toString() + " is a grad and researcher";
	}
}
