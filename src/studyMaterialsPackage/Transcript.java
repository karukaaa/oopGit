package studyMaterialsPackage;

import java.util.Map;
/**
 * Transcript class shows the transcript generated based on some student's grades
 */
public class Transcript {
	private Map<Course, Mark> marks;
    private int totalCredits;
/**
 * Constructor
 * @param marks grades of student
 * @param totalCredits totalCredits of student
 */
    public Transcript(Map<Course, Mark> marks, int totalCredits) {
        this.marks = marks;
        this.totalCredits = totalCredits;
    }

    /**
     * Getter for marks
     * @return marks
     */
    public Map<Course, Mark> getMarks() {
        return marks;
    }

    /**
     * Getter of total credits
     * @return total credits
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
