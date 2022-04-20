package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import AlgorithmsAndDataStructures.TimeKeeper;
import DataObjects.CustomFont;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

/*
GeneralInfo
        - Contains date
        - Contains time
        - Contains user name
*/

public class GeneralInfo extends JPanel {
    
    // Date formatter
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

    // Layout 
    FlowLayout flow = new FlowLayout();
    FlowLayout leftFlow = new FlowLayout(FlowLayout.LEFT);
    FlowLayout rightFlow = new FlowLayout(FlowLayout.RIGHT);

    // Panels
    JPanel usernamePanel = new JPanel(leftFlow);
    JPanel timePanel = new JPanel(flow);
    JPanel datePanel = new JPanel(rightFlow);

    // Icons
    ImageIcon userProfile = new ImageIcon("ClientTracker\\Images&Icons\\output-onlinepngtools.png");

    // Font object
    CustomFont font = new CustomFont(20);

    // Labels
    JLabel user = new JLabel();
    JLabel time = new JLabel();
    JLabel date = new JLabel();

    // Icon images
    JLabel userProfileLabel = new JLabel();
    JLabel timeLabel = new JLabel(); // DO later
    JLabel userProfileLable = new JLabel(); // Do later

    // Color of jpanels
    Color white = Color.WHITE;

    // Updates clock and date
    TimeKeeper timeKeep = new TimeKeeper(time, date);

    public GeneralInfo(String userName){
        GUISetup(userName);
        timeKeep.start();
      
    }

    void GUISetup(String userName){

        // Set username
        user.setText(userName);

        

        // This panel setup
        this.setLayout(new GridLayout(1, 3));
        this.add(usernamePanel);
        this.add(timePanel);
        this.add(datePanel);
        this.setBorder(new LineBorder(Color.BLACK));
        
        // Label properties
        time.setFont(font);
        date.setFont(font);
        user.setFont(font);

        // Image properties
        userProfileLabel.setIcon(userProfile);

        // Child panels
        usernamePanel.add(userProfileLabel);
        usernamePanel.add(user);
        timePanel.add(time);
        datePanel.add(date);
        
        // Panel colors
        this.setBackground(white);
        usernamePanel.setBackground(white);
        timePanel.setBackground(white);
        datePanel.setBackground(white);
    }



}
