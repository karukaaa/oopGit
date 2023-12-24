package testClasses;

import studyMaterialsPackage.*;
import usersPackage.*;

public class Main {
    public static void main(String[] args) {
        
        Course mathCourse = new Course("MATH001", "Mathematics 001");
//        Course bioCourse = new Course("BIOLOGY001", "Biology 001");

        Teacher mathTeacher = new Teacher("Mr.Agai", TeacherType.ACADEMIC);
        Student student = new Student("Anel");

        mathTeacher.assignCourse(mathCourse);
        
        student.enrollCourse(mathCourse);
        
        mathTeacher.putMark(student, mathCourse, 30, MarkTypes.ATT1);
        mathTeacher.putMark(student, mathCourse, 29, MarkTypes.ATT2);


        student.checkMarks();
    }
}
