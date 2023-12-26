package studyMaterialsPackage;

import java.util.Map;

/**
 * The {@code Transcript} class represents a student's academic transcript
 * containing a mapping of courses to corresponding marks and the total credits earned.
 *
 * <p>A transcript provides information about a student's academic performance in various courses.</p>
 *
 */
public class Transcript {

    /** A mapping of courses to corresponding marks. */
    private Map<Course, Mark> marks;

    /** The total credits earned by the student. */
    private int totalCredits;

    /**
     * Constructs a {@code Transcript} with the specified parameters.
     *
     * @param marks         a mapping of courses to corresponding marks
     * @param totalCredits  the total credits earned by the student
     */
    public Transcript(Map<Course, Mark> marks, int totalCredits) {
        this.marks = marks;
        this.totalCredits = totalCredits;
    }

    /**
     * Gets the mapping of courses to corresponding marks in the transcript.
     *
     * @return a map containing courses and their corresponding marks
     */
    public Map<Course, Mark> getMarks() {
        return marks;
    }

    /**
     * Gets the total credits earned by the student.
     *
     * @return the total credits earned
     */
    public int getTotalCredits() {
        return totalCredits;
    }
    
    /**
     * Method to print the transcript
     */
    public void printTranscript() {
	for(Map.Entry<Course, Mark> cur : marks.entrySet()) {
		Course course = cur.getKey();
		Mark mark = cur.getValue();
		System.out.println(course + " " + mark + course.getCredits());
		}
    }
    
}

