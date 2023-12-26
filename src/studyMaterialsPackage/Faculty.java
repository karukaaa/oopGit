package studyMaterialsPackage;

/**
 * The Faculty enum represents different academic faculties or departments.
 * It includes common faculties such as Economy, Education, IT, Health, and Engineering.
 */
public enum Faculty{
	ECONOMY, EDUCATION, IT, HEALTH, ENGINEERING;


    /**
     * Checks if the given input string is a valid faculty name.
     *
     * @param facultyInput The input string to be checked.
     * @return true if the input string matches any faculty name, false otherwise.
     */
    public static boolean isValidFaculty(String facultyInput) {
        for (Faculty faculty : values()) {
            if (faculty.name().equals(facultyInput)) {
                return true;}
        }
        return false;
    }
}
