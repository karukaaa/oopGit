package usersPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import studyMaterialsPackage.*;


public class ORManager extends Manager implements CanViewAcademicInfo {

    private List<Course> courses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    /**
     * The ORManager class represents a manager responsible for operations related to courses,
     * teachers, and students in an educational system.
     * It extends the Manager class and implements the CanViewAcademicInfo interface.
     */
    private Scanner scanner = new Scanner(System.in);
   
    /**
     * Constructs an ORManager with the specified name.
    *
    * @param name The name of the ORManager.
    */
    public ORManager(String name) {
        super(name, ManagerType.OR_MANAGER);    
    }


    /**
     * Adds a new course registration to the ORManager's list of courses.
    *
    * @param faculty      The faculty to which the course belongs.
    * @param courseName   The name of the course.
    * @param yearOfStudy  The year of study for the course.
    */
    public void addRegistrationCourse(Faculty faculty, String courseName, int yearOfStudy) {
        Course newCourse = new Course(courseName, faculty, yearOfStudy);
        courses.add(newCourse);
    }


    /**
     * Adds a new teacher to the ORManager's list of teachers.
    *
    * @param name The name of the teacher.
    * @param type The type of the teacher as defined in the TeacherType enumeration.
    */
    public void addTeacher(String name, TeacherType type) {
        Teacher newTeacher = new Teacher();
        teachers.add(newTeacher); 
    }


    
    /**
     * Adds a new student to the ORManager's list of students.
    *
    * @param name  The name of the student.
    * @param major The major or field of study for the student.
    */
    public void addStudent(int studentId, String name) {
        Student newStudent = new Student(new StudentBuilder(name, studentId));
        students.add(newStudent); 
    }


    /**
     * Creates a new lesson and returns it.
    *
    * @return The created Lesson object.
    */
    public Lesson createLesson() {
        return new Lesson(); 
    }


    /**
     * Gets the list of courses managed by the ORManager.
    *
    * @return The list of courses.
    */
    public List<Course> getCourses() {
        return courses; 
    }


    /**
     * Gets the list of teachers managed by the ORManager.
    *
    * @return The list of teachers.
    */
    public List<Teacher> getTeachers() {
        return teachers; 
    }


    /**
     * Gets the list of students managed by the ORManager.
    *
    * @return The list of students.
    */
    public List<Student> getStudents() {
        return students;
    }

    
    /**
     * Associates a student with a course by enrolling the student in the course.
    *
    * @param student The student to be associated.
    * @param course  The course in which the student will be enrolled.
    */
    public void associateStudentWithCourse(Student student, Course course) {
        student.enrollCourse(course); 
    }

    
    /**
     * Associates a teacher with a course by adding a lesson to the teacher's schedule.
    *
    * @param teacher The teacher to be associated.
    * @param course  The course for which the lesson is added to the teacher's schedule.
    */
    public void associateTeacherWithCourse(Teacher teacher, Course course) {
        teacher.addLessonToSchedule(new Lesson());
    }

    

    /**
     * Accepts user input to add multiple students.
     */
    public void addUserInputStudent() {
        System.out.print("Number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Student Name: ");
            String name = scanner.nextLine();
            System.out.print("StudentId: ");
            int studentId = scanner.nextInt();

            addStudent(studentId, name);
        }
    }

    

    
    /**
     * Accepts user input to add multiple courses.
     */
    public void addUserInputCourse() {
        System.out.print("Number of courses: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();

        
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Faculty (ECONOMY/EDUCATION/IT/HEALTH/ENGINEERING): ");
            Faculty faculty = null;
            try {
                String facultyInput = scanner.nextLine().toUpperCase();
                if (Faculty.isValidFaculty(facultyInput)) {
                    faculty = Faculty.valueOf(facultyInput);
                } else {
                    throw new IllegalArgumentException("Invalid faculty input. Please enter one of: ECONOMY, EDUCATION, IT, HEALTH, ENGINEERING.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }

            System.out.print("Course Name: ");
            String courseName = scanner.nextLine();
            System.out.print("Year of Study: ");
            int yearOfStudy = Integer.parseInt(scanner.nextLine());

            addRegistrationCourse(faculty, courseName, yearOfStudy);
        }
    }

    /**
     * Accepts user input to add multiple teachers.
     */
    public void addUserInputTeacher() {
        System.out.print("Number of teachers: ");
        int numTeachers = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numTeachers; i++) {
            System.out.print("Teacher Name: ");
            String name = scanner.nextLine();
            System.out.print("Teacher Type (PROFESSOR/DOCTOR/TRAINEE/ACADEMIC/PRACTITIONER): ");
            TeacherType type = TeacherType.valueOf(scanner.nextLine().toUpperCase());

            addTeacher(name, type);
        }
    }


    /**
     * Allows the ORManager to approve student registrations for courses.
     *
     * @param courses            The course or list of courses to be registered.
     * @param student            The student requesting registration.
     * @param intentionToAttend A boolean indicating the intention to attend the courses.
     */
    /**
     * Overrides the approveRegistration method from the Manager class.
     * Allows the ORManager to approve student registrations for courses.
     *
     * @param courses            The course or list of courses to be registered.
     * @param student            The student requesting registration.
     * @param intentionToAttend A boolean indicating the intention to attend the courses.
     */
    public void approveRegistration(Object courses, Student student, boolean intentionToAttend) {
        if (getType() == ManagerType.OR_MANAGER) {
            if (courses instanceof Course) {
                Course singleCourse = (Course) courses;
                if (intentionToAttend) {
                    associateStudentWithCourse(student, singleCourse);
                    update("Student " + student.getName() + " enrolled in course " + singleCourse.getCourseName());
                } else {
                    update("Student " + student.getName() + " does not have the intention to attend the course.");
                }
            } else if (courses instanceof List<?>) {
                List<?> courseList = (List<?>) courses;
                for (Object obj : courseList) {
                    if (obj instanceof Course) {
                        Course course = (Course) obj;
                        if (intentionToAttend) {
                            associateStudentWithCourse(student, course);
                            update("Student " + student.getName() + " enrolled in course " + course.getCourseName());
                        } else {
                            update("Student " + student.getName() + " does not have the intention to attend the course: " + course.getCourseName());
                        }
                    } else {
                        update("Invalid course object found in the list");
                    }
                }
            }
        } else {
            update("Access denied. Only OR Managers can approve registrations.");
        }
    }

    /**
     * Implements the viewAcademicInfo method from the CanViewAcademicInfo interface.
     * Provides functionality for viewing academic information.
     */
    @Override
    public void viewAcademicInfo() {
    	 //implementation
    }

    /**
     * Closes the scanner used for user input.
     */
    public void closeScanner() {
        scanner.close();
}
}