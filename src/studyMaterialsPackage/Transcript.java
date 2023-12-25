package studyMaterialsPackage;

import java.util.Map;

public class Transcript {
	private Map<Course, Mark> marks;
    private int totalCredits;

    public Transcript(Map<Course, Mark> marks, int totalCredits) {
        this.marks = marks;
        this.totalCredits = totalCredits;
    }

    public Map<Course, Mark> getMarks() {
        return marks;
    }

    public int getTotalCredits() {
        return totalCredits;
    }
}
