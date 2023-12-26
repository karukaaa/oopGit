package researchPackage;

/**
 * Custom exception for when a graduate student's supervisor has h-index < 3
 */
public class IncorrectSupervisorError extends Exception{
	public IncorrectSupervisorError(String string) {
		super(string);
	}
}
