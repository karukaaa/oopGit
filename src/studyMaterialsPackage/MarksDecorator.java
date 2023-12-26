package studyMaterialsPackage;
import usersPackage.Student;
import usersPackage.StudentBuilder;

/**
 * The {@code MarksDecorator} class is a decorator for the {@code Student} class,
 * adding additional behavior for viewing marks.
 *
 * <p>This class extends the functionality of a {@code Student} by allowing the student
 * to have additional behavior when checking marks.</p>
 *
 * <p>It is assumed that the behavior for viewing marks is added in the {@code checkMarks} method.</p>
 */
public class MarksDecorator extends Student {

    /** The underlying student object being decorated. */
    private Student student;

    /**
     * Constructs a {@code MarksDecorator} with the specified parameters.
     *
     * @param studentId the student's ID
     * @param major the student's major specialty
     * @param name the student's name
     * @param level the student's academic level
     * @param student the underlying student object to be decorated
     */
    public MarksDecorator(int studentId, Specialty major, String name, int level, Student student) {
        super(new StudentBuilder(studentId, major, name, level));
        this.student = student;
    }

    /**
     * Overrides the {@code checkMarks} method to provide additional behavior for viewing marks.
     */
    @Override
    public void checkMarks() {
        // Additional behavior for viewing marks, if needed
        student.checkMarks();
    }
}
