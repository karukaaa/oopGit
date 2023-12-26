package testClasses;

import studyMaterialsPackage.*;
import usersPackage.*;

public class Main {
    public static void main(String[] args) {
        
        Course mathCourse = new Course("MATH001", "Mathematics 001");
//        Course bioCourse = new Course("BIOLOGY001", "Biology 001");

        Teacher mathTeacher = new Teacher("Mr.Agai", TeacherType.ACADEMIC);
        Student student = new Student(new StudentBuilder(0, null, null, 0).setResearcher(true));

        mathTeacher.assignCourse(mathCourse);
        
        student.enrollCourse(mathCourse);
        
        mathTeacher.putMark(student, mathCourse, 30, MarkTypes.ATT1);
        mathTeacher.putMark(student, mathCourse, 29, MarkTypes.ATT2);


        student.checkMarks();
        
        GraduateStudent s = new GraduateStudent(new GraduateStudentBuilder("ame", 1).setType(GraduateStudentType.PHD));
    }
}
