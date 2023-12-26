package usersPackage;
/**
 * The Manager class represents an abstract manager in the system.
 * It extends the Employee class and implements the CanViewAcademicInfo and Observer interfaces.
 */
public abstract class Manager extends Employee implements CanViewAcademicInfo, Observer {
	
    private ManagerType type;
    
    /**
     * Constructs a Manager with the specified name and manager type.
     *
     * @param name The name of the manager.
     * @param type The type of the manager (ACADEM_MANAGER, OR_MANAGER, NEWS_MANAGER).
     */
       public Manager(String name, ManagerType type) {
        super(name);
        this.type = type;
        
    }
  
       /**
        * Gets the type of the manager.
       *
       * @return The type of the manager.
       */
    public ManagerType getType() {
        return type;       
    }

    /**
     * Abstract method for approving student registrations.
     *
     * @param courses            The course or list of courses to be registered.
     * @param student            The student requesting registration.
     * @param intentionToAttend A boolean indicating the intention to attend the courses.
     */  

    @Override
    /**
     * Overrides the update method from the Observer interface.
     * Prints a message indicating an update received by the manager.
     *
     * @param message The message received as an update.
     */
    public void update(String message) {
        System.out.println(getType() + " " + getName() + ": " + message);
        
    }
  
    /**
     * Abstract method for viewing academic information.
     */
    @Override
    public abstract void viewAcademicInfo();
    
}
