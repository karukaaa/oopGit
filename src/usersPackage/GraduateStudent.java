package usersPackage;

import java.util.*;

import researchPackage.*;
import studyMaterialsPackage.DiplomaProject;

public class GraduateStudent extends Student{
	
	ResearcherPerson supervisor;
	GraduateStudentType type;
	DiplomaProject diplomaProject;
	
	{
		super.research = new ResearcherPerson(this);
	}
	
	public GraduateStudent(GraduateStudentBuilder builder) {
		super(builder);
		this.supervisor = builder.supervisor;
		this.type = builder.type;
		this.diplomaProject = builder.diplomaProject;
	}
	
	
	public ResearcherPerson getResearch() {
		return research;
	}
	public void setResearch(ResearcherPerson research) {
		this.research = research;
	}

	public GraduateStudentType getType() {
		return type;
	}


	public void setType(GraduateStudentType type) {
		this.type = type;
	}
	

	public DiplomaProject getDiplomaProject() {
		return diplomaProject;
	}


	public void setDiplomaProject(DiplomaProject diplomaProject) {
		this.diplomaProject = diplomaProject;
	}
	public void setDiplomaProject() {
		this.diplomaProject = new DiplomaProject(this);
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
