package usersPackage;

import java.util.List;

public class StudentOrganization {
	 String name;
	    List<Student> members;

	    public StudentOrganization(String name, List<Student> members) {
	        this.name = name;
	        this.members = members;
	    }

	    public void addMember(Student student) {
	    	if (!members.contains(student)) {
	            members.add(student);
	            System.out.println("Student " + student.getName() + " added to the organization " + name);
	        } else {
	            System.out.println("Student " + student.getName() + " is already a member of the organization " + name);
	        }
	    }
}
