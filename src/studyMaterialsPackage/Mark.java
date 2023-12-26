package studyMaterialsPackage;
/**
 * Class Mark represents a mark of a student
 */
public class Mark {
    private Course course;
    private int score;
    private double firstAttestation;
    private double secondAttestation;
    private double midtermPoint;
    private double endtermPoint;
    private double finalPoint;
    
    /**
     * Empty constructor for creating a Mark instance.
     */
    public Mark() {
        	
    }

    /**
     * Constructor to initialize a Mark instance with a Course and a score.
     * @param course The Course associated with this Mark.
     * @param score The score attained in the Course.
     */
    public Mark(Course course, int score) {
        this.course = course;
        this.score = score;
    }

    /**
     * Retrieves the Course associated with this Mark.
     * @return The Course associated with this Mark.
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Retrieves the calculated total score for this Mark.
     * @return The total score calculated from various components.
     */
    public int getScore() {
        score = (int) (firstAttestation + secondAttestation + midtermPoint + endtermPoint + finalPoint);
        return score;
    }

    /**
     * Sets the total score for this Mark.
     * @param score The total score to set.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Retrieves the first attestation score.
     * @return The first attestation score.
     */
    public double getFirstAttestation() {
        return firstAttestation;
    }

    /**
     * Sets the first attestation score.
     * @param firstAttestation The first attestation score to set.
     */
    public void setFirstAttestation(double firstAttestation) {
        this.firstAttestation = firstAttestation;
    }

    /**
     * Retrieves the second attestation score.
     * @return The second attestation score.
     */
    public double getSecondAttestation() {
        return secondAttestation;
    }

    /**
     * Sets the second attestation score.
     * @param secondAttestation The second attestation score to set.
     */
    public void setSecondAttestation(double secondAttestation) {
        this.secondAttestation = secondAttestation;
    }

    /**
     * Retrieves the midterm point score.
     * @return The midterm point score.
     */
    public double getMidtermPoint() {
        return midtermPoint;
    }

    /**
     * Sets the midterm point score.
     * @param midtermPoint The midterm point score to set.
     */
    public void setMidtermPoint(double midtermPoint) {
        this.midtermPoint = midtermPoint;
    }

    /**
     * Retrieves the endterm point score.
     * @return The endterm point score.
     */
    public double getEndtermPoint() {
        return endtermPoint;
    }

    /**
     * Sets the endterm point score.
     * @param endtermPoint The endterm point score to set.
     */
    public void setEndtermPoint(double endtermPoint) {
        this.endtermPoint = endtermPoint;
    }

    /**
     * Retrieves the final point score.
     * @return The final point score.
     */
    public double getFinalPoint() {
        return finalPoint;
    }

    /**
     * Sets the final point score.
     * @param finalPoint The final point score to set.
     */
    public void setFinalPoint(double finalPoint) {
        this.finalPoint = finalPoint;
    }

    /**
     * Method to check is student passes the course
     * @return boolean value
     */
    public boolean isPass() {
        return score >= 60;
    }
    
    /**
     * Method to calculate the grade and return it as a letter
     * @return
     */
    public String calculateGrade() {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    /** 
     * toString returns info about the mark
     */
    public String toString() {
    	return this.firstAttestation + " " + this.secondAttestation + " " + this.finalPoint;
    }
}
