package usersPackage;


public abstract class Manager extends Employee implements CanViewAcademicInfo, Observer{
	private ManagerType type;
	
	public Manager(String name, ManagerType type) {
		super(name);
		this.type = type;
	}
	
	public ManagerType getType() {
		return type;
	}

	public abstract void approveRegistration(Object courses, Student student, boolean intentionToAttend);

    @Override
    public void update(String message) {
        System.out.println(getType() + " " + getName() + ": " + message);
    }
	@Override
	public void viewAcademicInfo() {
		// TODO Auto-generated method stub
		
	}

}
