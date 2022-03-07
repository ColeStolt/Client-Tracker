package GUI;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import DataObjects.CustomFont;
import DataObjects.CustomJTextField;

/*  Data Entry
        - Where data entry happens
        - New clients created
        - New clients stored
        - Contains a child tab
        - Must select a client
        - Child added to that client
    */

public class DataEntry extends JPanel{

    // Font
    CustomFont font = new CustomFont(20);

    // Constants
    private final short FIELD_SIZE = 15;

    // Layout
    FlowLayout flow = new FlowLayout(FlowLayout.CENTER);

    // Had a hard time with layouts so here we are.... JPanels
    private JPanel namePanel = new JPanel(flow);
    private JPanel phoneNumberPanel = new JPanel(flow);
    private JPanel addressPanel = new JPanel(flow);
    private JPanel startDatePanel = new JPanel(flow);
    private JPanel endDatePanel = new JPanel(flow);
    private JPanel lessonsPanel = new JPanel(flow);
    private JPanel addClientPanel = new JPanel(flow);

    // Labels
    JLabel lessonLabel = new JLabel("# of lessons");

    // Buttons
    private JButton addClient = new JButton("       Add Client       ");
    private JCheckBox paidInFull = new JCheckBox("Paid in full? |");
    private JComboBox<Integer> lessons = new JComboBox<>();

    // Text fields
    private CustomJTextField name = new CustomJTextField("Client Name", FIELD_SIZE);
    private CustomJTextField phoneNumber = new CustomJTextField("Phone Number", FIELD_SIZE);
    private CustomJTextField address = new CustomJTextField("Address", FIELD_SIZE);
    private CustomJTextField startDate = new CustomJTextField("Start Date", FIELD_SIZE);
    private CustomJTextField endDate = new CustomJTextField("End Date", FIELD_SIZE);

    public DataEntry(){

        populateComboBox();
        componentSetup();
        mainPanelSetup();
       
    }

    private void componentSetup(){
        // Component Properties
        addClient.setFont(font);
        addClient.setBorder(new RoundedBorder(5));
        paidInFull.setFont(font);
        paidInFull.setBackground(Color.WHITE);
        addClient.setBackground(new Color(146,210,147)); // Nice green color

        // Add components
        namePanel.add(name);
        phoneNumberPanel.add(phoneNumber);
        addressPanel.add(address);
        startDatePanel.add(startDate);
        endDatePanel.add(endDate);
        lessonsPanel.add(paidInFull);
        lessonsPanel.add(lessons);
        lessonsPanel.add(lessonLabel);
        addClientPanel.add(addClient);
    
        // Set properties
        namePanel.setBackground(Color.WHITE);
        phoneNumberPanel.setBackground(Color.WHITE);
        addressPanel.setBackground(Color.WHITE);
        startDatePanel.setBackground(Color.WHITE);
        endDatePanel.setBackground(Color.WHITE);
        lessonsPanel.setBackground(Color.WHITE);
        addClientPanel.setBackground(Color.WHITE);

        addClientPanel.setBorder(new LineBorder(Color.BLACK)); // I use line border twice
                                                            // But too lazy to make a class
                                                            // variable for it

    }

    private void mainPanelSetup(){
        // This properties
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(7, 1));
        this.setBorder(new LineBorder(Color.BLACK));

        // Add secondary panel components
        this.add(namePanel);
        this.add(phoneNumberPanel);  
        this.add(addressPanel);
        this.add(startDatePanel);
        this.add(endDatePanel);
        this.add(lessonsPanel);
        this.add(addClientPanel);
    }

    // Populates JComboBox and sets properties
    private void populateComboBox(){
        for (int i = 0; i < 51; i++) {
            lessons.addItem(i);
        }
        // Set label properties in here
        lessonLabel.setFont(font);
        // ComboBox properties
        lessons.setFont(new CustomFont(13));
    
    }
    
}
