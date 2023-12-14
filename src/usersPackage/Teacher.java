package usersPackage;
import java.util.HashMap;
import java.util.Map;

import studyMaterials.*;

public class Teacher {
    private String name;
    private Map<Course, Integer> marksToAssign = new HashMap<>();

    public Teacher(String name) {
        this.name = name;
    }

    public void assignMark(Student student, Course course, int score) {
        if (marksToAssign.containsKey(course)) {
            student.receiveMark(new Mark(course, score));
            System.out.println("Mark assigned successfully.");
        } else {
            System.out.println("You are not assigned to teach this course.");
        }
    }

    public void putMark(Student student, Course course, int score) {
        if (marksToAssign.containsKey(course)) {
            student.receiveMark(new Mark(course, score));
            System.out.println("Mark assigned successfully.");
        } else {
            System.out.println("You are not assigned to teach this course.");
        }
    }

    public void assignCourse(Course course) {
        marksToAssign.put(course, 0);
        System.out.println("You are now assigned to teach " + course.getCourseName());
    }

    public void seeNews() {
        System.out.println("Viewing news as a teacher.");
    }

    public void viewEnrolledStudents() {
        System.out.println("Viewing enrolled students as a teacher.");
    }

}
