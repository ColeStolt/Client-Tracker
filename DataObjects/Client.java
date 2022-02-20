import java.util.ArrayList;

public class Client {
    
    // Client definitions
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String startDate;
    private String endDate;
    private float amountPerLesson;
    private boolean paidInFull;

    // Holds a list of children
    ArrayList<Child> children = new ArrayList<Child>();

    // Default and parameterized constructor
    public Client(){
        firstName = "null";
        lastName = "null";
        phoneNumber = "000-000-0000";
        address = "null";
        startDate = "00/00/0000";
        endDate = "00/00/0000";
        amountPerLesson = 0.0f;
        paidInFull = false;
    }

    // Parameterized constructor
    public Client(String firstName, String lastName, String phoneNumber, String address, String startDate, String endDate, float amountPerLesson, boolean paidInFull){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountPerLesson = amountPerLesson;
        this.paidInFull = paidInFull;
    }

    // Client behaviors
    // Add child to client's list
    public void addChild(Child child){
        children.add(child);
        System.out.println(children.get(0));
    }

    // Removes child based on name due to clients having
    // Different children (obviously)
    public void removeChild(String childFirstName){
        // Look for children based on name due to children most likely
        // Not having the same first name as one another.
        for(int i = 0; i < children.size(); i++){
            if (children.get(i).getFirstName() == childFirstName){
                children.remove(i);
            }
        }
    }

    // Setters / Getters
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public float getAmountPerLesson() {
        return this.amountPerLesson;
    }

    public void setAmountPerLesson(float amountPerLesson) {
        this.amountPerLesson = amountPerLesson;
    }

    public boolean isPaidInFull() {
        return this.paidInFull;
    }

    public void setPaidInFull(boolean paidInFull) {
        this.paidInFull = paidInFull;
    }
}
