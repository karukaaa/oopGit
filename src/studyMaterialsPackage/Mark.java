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
//    	score = (int) (score-this.firstAttestation + firstAttestation);
        this.firstAttestation = firstAttestation;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    public void setSecondAttestation(double secondAttestation) {
//    	score = (int) (score-this.secondAttestation + secondAttestation);
        this.secondAttestation = secondAttestation;
    }

    public double getMidtermPoint() {
        return midtermPoint;
    }

    public void setMidtermPoint(double midtermPoint) {
//    	score = (int) (score-this.midtermPoint + midtermPoint);
        this.midtermPoint = midtermPoint;
    }

    public double getEndtermPoint() {
        return endtermPoint;
    }

    public void setEndtermPoint(double endtermPoint) {
//    	score = (int) (score-this.endtermPoint + endtermPoint);
        this.endtermPoint = endtermPoint;
    }

    public double getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(double finalPoint) {
//    	score = (int) (score-this.finalPoint + finalPoint);
        this.finalPoint = finalPoint;
    }
}
