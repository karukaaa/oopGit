package usersPackage;

import java.util.*;

import researchPackage.*;
import studyMaterialsPackage.DiplomaProject;

/**
 * The {@code GraduateStudent} class represents a graduate student who is also a researcher,
 * extending the functionality of the {@code Student} class.
 *
 * <p>A graduate student may have a supervisor, conduct research, and have a specific student type.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-01-01
 */
public class GraduateStudent extends Student{
	
	/** The supervisor of the graduate student. */
    ResearcherPerson supervisor;

    /** The type of graduate student (e.g., Master's or Ph.D.). */
    GraduateStudentType type;

    /** The diploma project of a graduate student */    
	private DiplomaProject diplomaProject;

    /**
     * Initializes the researcher associated with the graduate student.
     * This is done using an instance initializer block.
     */
    {
        super.research = new ResearcherPerson(this);
    }
	
    /**
     * Constructor that uses builder pattern
     * @param builder
     */
	public GraduateStudent(GraduateStudentBuilder builder) {
		super(builder);
		this.supervisor = builder.supervisor;
		this.type = builder.type;
		this.diplomaProject = builder.diplomaProject;
	}
	public void setResearch(ResearcherPerson research) {
        this.research = research;
    }

    /**
     * Gets the type of the graduate student (e.g., Master's or Ph.D.).
     *
     * @return the type of graduate student
     */
    public GraduateStudentType getType() {
        return type;
    }

    /**
     * Sets the type of the graduate student.
     *
     * @param type the type of graduate student
     */
    public void setType(GraduateStudentType type) {
        this.type = type;
    }

    /**
     * Sets the supervisor of the graduate student, subject to a condition on the supervisor's h-index.
     *
     * @param supervisor the supervisor of the graduate student
     */
    public void setSupervisor(ResearcherPerson supervisor) {
        try {
            if (supervisor.calculateHindex() < 3)
                throw new IncorrectSupervisorError("This researcher has an h-index less than 3");
        } catch (IncorrectSupervisorError e) {
            System.out.println(e);
        }
    }

    /**
     * Gets the supervisor of the graduate student.
     *
     * @return the supervisor of the graduate student
     */
    public ResearcherPerson getSupervisor() {
        return supervisor;
    }

    /**
     * Returns a string representation of the graduate student.
     *
     * @return a string representation of the graduate student
     */
    @Override
    public String toString() {
        return super.toString() + " is a grad and researcher";
    }

    /**
     * Method to set a diploma project
     * @param diplomaProject existing Diploma project
     */
	public void setDiplomaProject(DiplomaProject diplomaProject) {
		this.diplomaProject = diplomaProject;
	}
	
}
