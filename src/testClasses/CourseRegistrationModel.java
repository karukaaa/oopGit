package testClasses;
import java.util.*;

import usersPackage.*;
import communicationsPackage.*;
import researchPackage.*;
import studyMaterialsPackage.*;

public class CourseRegistrationModel {
	 private Scanner scanner = new Scanner(System.in);	


        public void main(String[] args) {
            ORManager orManager = new ORManager();

            // Add courses
            orManager.addUserInputCourse();
            orManager.addUserInputCourse();

            // Add students
            orManager.addUserInputStudent();
            orManager.addUserInputStudent();

            // Add teachers
            orManager.addUserInputTeacher();
            orManager.addUserInputTeacher();

            // Register students for courses
            Student alice = orManager.getStudents().get(0);
            Course javaCourse = orManager.getCourses().get(0);
            orManager.approveRegistration(Arrays.asList(javaCourse), alice);

            scanner.close();
        }
    
}
