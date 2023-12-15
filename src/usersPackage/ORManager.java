package usersPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import studyMaterialsPackage.*;


public class ORManager {
	private List<Course> courses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    
    private Scanner scanner = new Scanner(System.in);	

    public void addRegistrationCourse(Faculty faculty, String courseName, int yearOfStudy) {
        Course newCourse = new Course(courseName, faculty, yearOfStudy);
        courses.add(newCourse);
    }

    public void addTeacher(String name, TeacherType type) {
        Teacher newTeacher = new Teacher();
        teachers.add(newTeacher);
    }

    public void addStudent(String name, String major) {
        Student newStudent = new Student(name, major);
        students.add(newStudent);
    }

    public void approveRegistration(List<Course> courses, Student student) {
        student.approveRegistration(courses);
    }

    public Lesson createLesson() {
        return new Lesson();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }
    
    public void addUserInputStudent() {
        System.out.println("Enter student details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Major: ");
        String major = scanner.nextLine();

        addStudent(name, major);
    }
    
    public void addUserInputCourse() {
        System.out.println("Enter course details:");
        System.out.print("Faculty (SCIENCE/ENGINEERING): ");
        Faculty faculty = null;
        try {
            faculty = Faculty.valueOf(scanner.nextLine().toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("Course Name: ");
        String courseName = scanner.nextLine();
        System.out.print("Year of Study: ");
        int yearOfStudy = Integer.parseInt(scanner.nextLine());

        addRegistrationCourse(faculty, courseName, yearOfStudy);
    }
    
    public void addUserInputTeacher() {
        System.out.println("Enter teacher details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Teacher Type (PROFESSOR/DOCTOR): ");
        TeacherType type = TeacherType.valueOf(scanner.nextLine().toUpperCase());

        addTeacher(name, type);
    }
}
