package DataObjects;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/* Class was created to save me the headache of setting the
properties for each new TextField I use.
*/

// General font size of 20 will most likely be used
public class CustomJTextField extends JTextField {

    private final short FONT_SIZE = 20;

    public CustomJTextField(String title, int size, int fontSize){
        super(size); // For parents constructor properties
        super.setBorder(new TitledBorder(new LineBorder(Color.BLACK), title));
        super.setFont(new CustomFont(fontSize));
        super.setMaximumSize(new Dimension(300, 25));
    }

    // Second possible constructor for default fontSize of 20
    public CustomJTextField(String title, int size){
        super(size); // For parents constructor properties
        super.setBorder(new TitledBorder(new LineBorder(Color.BLACK), title));
        super.setFont(new CustomFont(FONT_SIZE));
        super.setMaximumSize(new Dimension(300, 25));
    }


}
