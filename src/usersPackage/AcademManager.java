package usersPackage;
/**
 * The AcademManager class represents a manager with academic-related responsibilities
 * and the ability to view academic information.
 * It extends the Manager class and implements the CanViewAcademicInfo interface.
 */
public class AcademManager extends Manager implements CanViewAcademicInfo {
	
	/**
     * Constructs an AcademManager with the specified name and manager type.
     *
     * @param name The name of the AcademManager.
     * @param type The type of the manager as defined in the ManagerType enumeration.
     */
    public AcademManager(String name, ManagerType type) {
        super(name, type);
    }
    
    
    /**
     * Allows the AcademManager to view academic information.
     * This method should be implemented based on the specific functionality.
     */
    public void viewAcademicInfo() {
    	 //implementation
    }
}
