package testClasses;

import usersPackage.*;
public class CourseRegistrationModel {

        public void main(String[] args) {
        	ORManager orManager = new ORManager("OR Manager");

        	// Add courses
            orManager.addUserInputCourse();

            // Add students
            orManager.addUserInputStudent();

            // Add teachers
            orManager.addUserInputTeacher();

            System.out.println("\nStudents:");
            for (Student student : orManager.getStudents()) {
                student.displayCourses();
            }

            System.out.println("\nTeachers:");
            for (Teacher teacher : orManager.getTeachers()) {
                teacher.displayType();
            }

            orManager.closeScanner();
        }
}
