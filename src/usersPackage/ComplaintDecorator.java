package usersPackage;

import communicationsPackage.UrgencyLevel;
import studyMaterialsPackage.Specialty;

public class ComplaintDecorator extends Student {
	 private Student student;
	 
	public ComplaintDecorator(int studentId, Specialty major, String name, int level, Student student) {
		super(new StudentBuilder(studentId, major, name, level));
		this.student = student;
	}
	
	@Override
    public void checkMarks() {
        student.checkMarks();
    }

	
	 // Additional behavior for sending complaints to the dean
    public void sendComplaint(String complaint, UrgencyLevel urgencyLevel) {
    	// Implement the logic to send complaints to the dean based on urgency level
        // For example:
        System.out.println("Complaint sent to the dean: " + complaint + " - Urgency: " + urgencyLevel);
        // You can have more detailed logic to handle the complaint sending process
    }
    }


