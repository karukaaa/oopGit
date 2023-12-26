package researchPackage;

/**
 * custom exception for when someone who is not a research tries to join a research project
 */
public class NotResearcherError extends Exception{
	public NotResearcherError(String string) {
		super(string);
	}
}
