package studyMaterialsPackage;


public enum Faculty {
    ECONOMY, EDUCATION, IT, HEALTH, ENGINEERING;

    public static boolean isValidFaculty(String facultyInput) {
        for (Faculty faculty : values()) {
            if (faculty.name().equals(facultyInput)) {
                return true;
            }
        }
        return false;
    }
}
