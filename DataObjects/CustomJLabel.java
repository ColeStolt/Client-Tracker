package DataObjects;

import javax.swing.JLabel;

public class CustomJLabel extends JLabel{



    public CustomJLabel(String text, int fontSize){
        // Removes all commas from the data
        text = text.replaceAll(",", "");
        
        CustomFont font = new CustomFont(fontSize);
        this.setFont(font);
    }
    
}
