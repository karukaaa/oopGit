package usersPackage;

import communicationsPackage.UrgencyLevel;
import studyMaterialsPackage.Specialty;

/**
 * The {@code ComplaintDecorator} class is a decorator for the {@code Student} class,
 * adding the ability to send complaints to the dean.
 *
 * <p>This class extends the functionality of a {@code Student} by allowing the student
 * to send complaints with a specified urgency level to the dean.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-01-01
 */
public class ComplaintDecorator extends Student {

    /** The underlying student object being decorated. */
    private Student student;

    /**
     * Constructs a {@code ComplaintDecorator} with the specified parameters.
     *
     * @param studentId   the student's ID
     * @param major       the student's major specialty
     * @param name        the student's name
     * @param level       the student's academic level
     * @param student     the underlying student object to be decorated
     */
    public ComplaintDecorator(int studentId, Specialty major, String name, int level, Student student) {
        super(new StudentBuilder(studentId, major, name, level));
        this.student = student;
    }

    /**
     * Checks the marks of the decorated student.
     * This method delegates the call to the underlying student's {@code checkMarks} method.
     */
    @Override
    public void checkMarks() {
        student.checkMarks();
    }

    /**
     * Sends a complaint to the dean with the specified urgency level.
     *
     * @param complaint     the content of the complaint
     * @param urgencyLevel  the urgency level of the complaint
     */
    public void sendComplaint(String complaint, UrgencyLevel urgencyLevel) {
        // Implement the logic to send complaints to the dean based on urgency level
        // For example:
        System.out.println("Complaint sent to the dean: " + complaint + " - Urgency: " + urgencyLevel);
        // You can have more detailed logic to handle the complaint sending process
    }
}
