public class Child {
    
    // Child definitions
    private String firstName;
    private String dateOfBirth;
    private int numberOfLessons;

    // Default constructor
    public Child(String firstName, String dateOfBirth, int numberOfLessons){
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.numberOfLessons = numberOfLessons;
    }

    // Setters / Getters
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getNumberOfLessons() {
        return this.numberOfLessons;
    }

    public void setNumberOfLessons(int numberOfLessons) {
        this.numberOfLessons = numberOfLessons;
    }
    
}
