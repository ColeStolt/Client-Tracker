package DataObjects;

import javax.swing.JLabel;

// Allows for editing and searching for proper client
// when it is selected 

// Takes phone number as each client has a different phone
// number

public class CustomSearchLabel extends JLabel {
    
    // For hash lookup
    private String phoneNumber;

    public CustomSearchLabel(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    // Setters / Getters
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

}
