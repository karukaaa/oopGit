package usersPackage;

import researchPackage.ResearcherPerson;
import studyMaterialsPackage.DiplomaProject;
import studyMaterialsPackage.Specialty;

public class GraduateStudentBuilder extends StudentBuilder{
	
	ResearcherPerson supervisor;
	ResearcherPerson research;
	GraduateStudentType type;
	DiplomaProject diplomaProject;
	
	/**
	 * Constructor for a GraduateStudentBuilder with the name and student ID.
     * @param name The name of the student.
     * @param studentId The ID of the student.
	 * @param name
	 * @param studentId
	 */
	
	public GraduateStudentBuilder(String name, int studentId) {
    	super(name, studentId);
    }

	/**
     * Constructs a GraduateStudentBuilder with specific attributes.
     * @param studentId The ID of the student.
     * @param major The major specialty of the student.
     * @param name The name of the student.
     * @param level The level of the student.
     */
	public GraduateStudentBuilder(int studentId, Specialty major, String name, int level) {
		super(studentId, major, name, level);
	}

	public GraduateStudentBuilder setSupervisor(ResearcherPerson supervisor) {
		this.supervisor = supervisor;
		return this;
	}

	public GraduateStudentBuilder setResearch(ResearcherPerson research) {
		this.research = research;
		return this;
	}

	public GraduateStudentBuilder setType(GraduateStudentType type) {
		this.type = type;
		return this;
	}

	public GraduateStudentBuilder setDiplomaProject(DiplomaProject diplomaProject) {
		this.diplomaProject = diplomaProject;
		return this;
	}
	

}
