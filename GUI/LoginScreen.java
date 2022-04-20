package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import AlgorithmsAndDataStructures.DataParser;
import DataObjects.CustomFont;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Login Screen
    - User enters a username
    - User enters a password
    - Read Username file
    - Read password file
    - Un-hash them
    - Checks if valid
*/

public class LoginScreen {
    
    // Data 
    private String password;
    private String username;

    // For password and username checking
    DataParser parse = new DataParser();

    // Frames and Dimension
    private JFrame frame = new JFrame("Client Tracker Login");
    private Dimension frameSize = new Dimension(400, 250);

    // Panels
    private JPanel mainPanel = new JPanel();
    private JPanel userPanel = new JPanel();
    private JPanel passPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    
    // Icons for login screen
    ImageIcon icon = new ImageIcon("ClientTracker\\Images&Icons\\profile-user.png");

    //  Layouts
    FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 5, 10);
    GridLayout grid = new GridLayout(3, 1);
    
    // Buttons
    private JButton login = new JButton("         Login         ");

    // Font
    CustomFont font = new CustomFont(20);

    // Textfields
    JTextField usernameField = new JTextField(15);
    JPasswordField passwordField = new JPasswordField(15);

    // Labels
    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel(" Password: ");

    // Default constructor will be only constructor
    public LoginScreen(){
        GUISetup();
    }

    // This function will be in all gui applications
    private void GUISetup(){

        // Label Characteristics
        usernameLabel.setFont(font);
        passwordLabel.setFont(font);

        // Text field characteristics
        usernameField.setFont(font);
        passwordField.setFont(font);
        usernameField.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Username"));
        passwordField.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Password"));
       

        // Button Characteristics 
        login.setFont(font);
        login.setBorder(new RoundedBorder(5));
        login.addActionListener(new ActionListener(){ // Anonymous class for button action
            @Override
            public void actionPerformed(ActionEvent e) {
                password = String.valueOf(passwordField.getPassword()); // Password converted to string and will float around in the string pool. THIS IS, DANGEROUS BUT IS FINE RIGHT NOW
                username = usernameField.getText();
                //if (parse.hashAndRetrieve(username, "ClientTracker\\Data\\usernames.txt") && parse.hashAndRetrieve(password, "ClientTracker\\Data\\passwords.txt")){
                    frame.dispose();    // Removes login screen
                    new MainFrame("Client Tracker", 1280, 720, usernameField.getText()); // Opens main application window if password is correct
               //}
                //else{   // Informs user of incorrect username or password
                  // JOptionPane.showMessageDialog(null, "Incorrect username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                   
                   // passwordField.setText("");
              //}
                
            }
        });

        // Panel characteristics
        mainPanel.setLayout(grid);
        userPanel.setLayout(flow);
        passPanel.setLayout(flow);
        buttonPanel.setLayout(flow);

        // Panel components
        mainPanel.add(userPanel);
        mainPanel.add(passPanel);
        mainPanel.add(buttonPanel);
        userPanel.add(usernameField);
        userPanel.setBackground(Color.WHITE);
        passPanel.add(passwordField);
        passPanel.setBackground(Color.WHITE);
        buttonPanel.add(login);
        buttonPanel.setBackground(Color.WHITE);

        // Frame components
        frame.add(mainPanel);

        // Frame characteristics
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameSize);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
}
