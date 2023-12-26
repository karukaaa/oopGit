package communicationsPackage;

import usersPackage.Student;

public class UrgencyComplaint {
	UrgencyLevel level;
	Student student;
	String text;
	public UrgencyLevel getLevel() {
		return level;
	}
	public void setLevel(UrgencyLevel level) {
		this.level = level;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
