package studyMaterialsPackage;

import usersPackage.Student;
import usersPackage.StudentBuilder;

public class MarksDecorator extends Student {
	private Student student;
	
	public MarksDecorator(int studentId, Specialty major, String name, int level, Student student) {
		super(new StudentBuilder(studentId, major, name, level));
		this.student = student;
	}
    
	  @Override
	    public void checkMarks() {
	        // Additional behavior for viewing marks, if needed
	        student.checkMarks();
	    }
}
