package studyMaterialsPackage;

public class Mark {
    private Course course;
    private int score;
    private double firstAttestation;
    private double secondAttestation;
    private double midtermPoint;
    private double endtermPoint;
    private double finalPoint;
    
    public Mark() {
    	
    }

    public Mark(Course course, int score) {
        this.course = course;
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }
    

    public int getScore() {
    	score = (int) (firstAttestation + secondAttestation + midtermPoint + endtermPoint + finalPoint);
        return score;
    }
    public void setScore(int score) {
    	this.score = score;
    }

    public double getFirstAttestation() {
        return firstAttestation;
    }

    public void setFirstAttestation(double firstAttestation) {
    	this.firstAttestation = firstAttestation;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    public void setSecondAttestation(double secondAttestation) {
    	this.secondAttestation = secondAttestation;
    }

    public double getMidtermPoint() {
        return midtermPoint;
    }

    public void setMidtermPoint(double midtermPoint) {
    	this.midtermPoint = midtermPoint;
    }

    public double getEndtermPoint() {
        return endtermPoint;
    }

    public void setEndtermPoint(double endtermPoint) {
    	this.endtermPoint = endtermPoint;
    }

    public double getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(double finalPoint) {
        this.finalPoint = finalPoint;
    }
    
    public boolean isPass() {
        return score >= 60;
    }
    
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
    
    public String toString() {
    	return this.firstAttestation + " " + this.secondAttestation + " " + this.finalPoint;
    }
}
