package usersPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import studyMaterialsPackage.*;

/**
 * The AcademManager class represents a manager with academic-related responsibilities
 * and the ability to view academic information.
 * It extends the Manager class and implements the CanViewAcademicInfo interface.
 */
public class AcademManager extends Manager implements CanViewAcademicInfo {
	
	private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
	
	
	/**
     * Constructs an AcademManager with the specified name and manager type.
     *
     * @param name The name of the AcademManager.
     * @param type The type of the manager as defined in the ManagerType enumeration.
     */
    public AcademManager(String name, ManagerType type) {
        super(name, type);
    }
 
    
    public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student s) {
		students.add(s);
	}
	public void removeStudent(Student s) {
		students.remove(s);
	}
	public void addTeacher(Teacher t) {
		teachers.add(t);
	}
	public void removeTeacher(Teacher t) {
		teachers.remove(t);
	}


	/**
     * Allows the AcademManager to view academic information.
     * This method should be implemented based on the specific functionality.
     */
    public void viewAcademicInfo() {
    	 //implementation
    }
    
    public void generateFailedCoursesReport() {
    	for(Student cur : students) {
    		System.out.println(cur.toString() + cur.getFailedCourses());
    	}
    }
    public void generateMarkReport() {
    	for(Student cur : students) {
    		Map<Course, Mark> m = cur.getMarks();
    		System.out.println(cur.id + " ");
    		for(Map.Entry<Course, Mark> mark : m.entrySet()) {
    			System.out.println(mark.getKey().toString());
    		}
    	}
    }
}
