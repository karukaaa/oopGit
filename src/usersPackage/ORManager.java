package usersPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import studyMaterialsPackage.*;


public class ORManager extends Manager implements CanViewAcademicInfo{
	private List<Course> courses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    
    private Scanner scanner = new Scanner(System.in);	
    
    public ORManager(String name) {
        super(name, ManagerType.OR_MANAGER);
    }

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
    
   
    public void associateStudentWithCourse(Student student, Course course) {
        student.enrollCourse(course);
    }
    public void associateTeacherWithCourse(Teacher teacher, Course course) {
        teacher.addLessonToSchedule(new Lesson());
    }
    
    
    public void addUserInputStudent() {
        System.out.print("Number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Major: ");
            String major = scanner.nextLine();

            addStudent(name, major);
        }
    }
    
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

	@Override
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
	
	public void viewAcademicInfo() {
        // Implementation for viewing academic info
    }
	
	public void closeScanner() {
        scanner.close();
    }
}
