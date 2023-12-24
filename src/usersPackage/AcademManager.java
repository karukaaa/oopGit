package usersPackage;


public class AcademManager extends Manager implements CanViewAcademicInfo{

	public AcademManager(String name, ManagerType type) {
		super(name, type);
	}
	
	public void viewAcademicInfo() {
    }

	@Override
    public void approveRegistration(Object courses, Student student, boolean intentionToAttend) {
        update("Access denied. Academ Managers cannot approve registrations.");
    }

}
