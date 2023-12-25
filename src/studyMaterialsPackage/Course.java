package studyMaterialsPackage;

import java.util.ArrayList;
import java.util.List;

import usersPackage.*;

public class Course {
    private String courseCode;
    private String courseName;
    private Faculty faculty;
    private int yearOfStudy;
    private int credits;
    private List<Teacher> teachers = new ArrayList<>();

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
    
    public Course(String courseName, Faculty faculty, int yearOfStudy) {
        this.courseName = courseName;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
    
    
}
