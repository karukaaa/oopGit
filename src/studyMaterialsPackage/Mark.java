package studyMaterialsPackage;

public class Mark {
    private Course course;
    private int score;
    private double firstAttestation;
    private double secondAttestation;
    private double midtermPoint;
    private double endtermPoint;
    private double finalPoint;
    private double totalScore;

    public Mark(Course course, int score) {
        this.course = course;
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public int getScore() {
        return score;
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

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }
}
