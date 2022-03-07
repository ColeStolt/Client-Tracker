package GUI;

import javax.swing.JFrame;

/* This will hold the 3 Jpanels that make up the program:
    Client View
        - Shows a list of clients
        - Each item is interactable
        - More functions will come
    Data Entry
        - Where data entry happens
        - New clients created
        - New clients stored
        - Contains a child tab
        - Must select a client
        - Child added to that client
    GeneralInfo
        - Contains date
        - Contains time
        - Contains user name
*/

public class MainFrame extends JFrame{

    public MainFrame(String title, int width, int height){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    
}
