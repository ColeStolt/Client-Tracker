package DataObjects;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Client {
    
    // Client definitions
    private String name;
    private String phoneNumber;
    private String address;
    private String startDate;
    private String endDate;
    private String instructor;
    private int numberOflessons;
    private int numberOfChildren;
    private int amountPerLesson;

    // Holds a list of children
    private ArrayList<Child> children = new ArrayList<Child>();

    // Default and parameterized constructor
    public Client(){
        name = "null";
        phoneNumber = "000-000-0000";
        address = "null";
        startDate = "00/00/0000";
        endDate = "00/00/0000";
        setInstructor("null");
        amountPerLesson = 0;
        numberOfChildren = 0;
        amountPerLesson = 0;
    }

    // Parameterized constructor
    public Client(String name, String phoneNumber, String address, String startDate, String endDate, String instructor, int numberOflessons, int numberOfChildren, int amountPerLesson){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.setInstructor(instructor);
        this.numberOflessons = numberOflessons;
        this.numberOfChildren = numberOfChildren;
        this.amountPerLesson = amountPerLesson;
    }

    // Client behaviors
    // Add child to client's list
    public void addChild(Child child){
        children.add(child);
    }

    // Removes child based on name due to clients having
    // Different children (obviously)
    public void removeChild(String childFirstName){
        // Look for children based on name due to children most likely
        // Not having the same first name as one another.
        for(int i = 0; i < children.size(); i++){
            if (children.get(i).getFirstName() == childFirstName){
                // Inform of removed child
                JOptionPane.showMessageDialog(null, "Child \"" + children.get(i).getFirstName() + "\" successfully.");
                
                // Remove the child
                children.remove(i);

                return;
            }
        }

        // Let user know child does not exist
        JOptionPane.showMessageDialog(null, "Child \"" + childFirstName + "\" does not exist. Nothing removed.");
    }

    // Setters / Getters
    public String getFirstName() {
        return this.name;
    }

    public void setFirstName(String name) {
        this.name = name;
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getAmountPerLesson() {
        return this.amountPerLesson;
    }

    public void setAmountPerLesson(int amountPerLesson) {
        this.amountPerLesson = amountPerLesson;
    }

    public void setNumberOfLessons(int numberOflessons){
        this.numberOflessons = numberOflessons;
    }

    public int getNumberOfLessons(){
        return numberOflessons;
    }

    public void setNumberOfChildren(int numberOfChildren){
        this.numberOfChildren = numberOfChildren;
    }

    public int getNumberOfChildren(){
        return this.numberOfChildren;
    }
}
