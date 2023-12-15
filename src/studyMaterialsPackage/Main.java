package studyMaterialsPackage;

import usersPackage.*;

public class Main {
    public static void main(String[] args) {
        
        Course mathCourse = new Course("MATH001", "Mathematics 001");
//        Course bioCourse = new Course("BIOLOGY001", "Biology 001");

        Teacher mathTeacher = new Teacher("Mr.Agai");
        Student student = new Student("Anel");

        mathTeacher.assignCourse(mathCourse);
        mathTeacher.assignMark(student, mathCourse, 95);


        student.checkMarks();
    }
}
