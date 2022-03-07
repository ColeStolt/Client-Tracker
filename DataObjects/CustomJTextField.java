package DataObjects;

import java.awt.Font;

/* Simple custom font. Makes life easier
    and prevents the need for creating 
    multiple different font objects in
    different classes and re-filling 
    the same data.
*/

public class CustomFont extends Font{

    public CustomFont(int fontSize) {
        super("Verdana", Font.PLAIN, fontSize);
    }
    
}
