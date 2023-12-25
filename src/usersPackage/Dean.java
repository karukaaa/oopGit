package usersPackage;

import java.util.Vector;

public class Dean extends Employee {
	private Vector<String> studentComplaints = new Vector<>();
	private String faculty;

    public Dean(String name, String faculty) {
        super(name);
        this.faculty = faculty;
    }
    
    public String getFaculty() {
        return faculty;
    }

    // Additional methods specific to the Dean class can be added here
 // Method to handle student complaints
    public void handleStudentComplaint(String complaint) {
        studentComplaints.add(complaint);
    }

    // Method to view student complaints
    public Vector<String> viewStudentComplaints() {
        return studentComplaints;
    }
}
