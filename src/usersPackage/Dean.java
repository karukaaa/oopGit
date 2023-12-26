package usersPackage;

import java.util.Vector;

/**
 * The {@code Dean} class represents a dean within an educational institution, extending the functionality
 * of the {@code Employee} class.
 *
 * <p>A dean is responsible for managing student complaints, handling administrative tasks, and overseeing
 * the affairs of a specific faculty.</p>
 *
 * <p>Additional methods specific to the {@code Dean} class, such as handling student complaints and
 * viewing complaints, are provided in this class.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-01-01
 */
public class Dean extends Employee {

    /** The vector to store student complaints. */
    private Vector<String> studentComplaints = new Vector<>();

    /** The faculty associated with the dean. */
    private String faculty;

    /**
     * Constructs a {@code Dean} with the specified name and faculty.
     *
     * @param name the name of the dean
     * @param faculty the faculty associated with the dean
     */
    public Dean(String name, String faculty) {
        super(name);
        this.faculty = faculty;
    }

    /**
     * Gets the faculty associated with the dean.
     *
     * @return the faculty of the dean
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * Handles a student complaint by adding it to the list of student complaints.
     *
     * @param complaint the complaint to be handled
     */
    public void handleStudentComplaint(String complaint) {
        studentComplaints.add(complaint);
    }

    /**
     * Views the list of student complaints.
     *
     * @return a vector containing student complaints
     */
    public Vector<String> viewStudentComplaints() {
        return studentComplaints;
    }
}
