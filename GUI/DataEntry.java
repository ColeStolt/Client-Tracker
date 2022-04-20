package GUI;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.FlowLayout;

import DataObjects.Client;
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

    // Instructor names
    String[] instructors = {"Charity", "Dennise", "Kaci", "Allie", "Cody"};

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
    private JPanel instructorPanel = new JPanel(flow);
    private JPanel lessonsPanel = new JPanel(flow);
    private JPanel addClientPanel = new JPanel(flow);

    // Buttons
    private JButton addClient = new JButton("       Add Client       ");
    private JComboBox<Integer> lessons = new JComboBox<>();
    private JComboBox<Integer> amountPerLesson = new JComboBox<>();
    private JComboBox<Integer> numberOfChildren = new JComboBox<>();
    private JComboBox<String> instructorsBox = new JComboBox<>(instructors);

    // Text fields
    private CustomJTextField name = new CustomJTextField("Client Name", FIELD_SIZE);
    private CustomJTextField phoneNumber = new CustomJTextField("Phone Number", FIELD_SIZE);
    private CustomJTextField address = new CustomJTextField("Address", FIELD_SIZE);
    private CustomJTextField startDate = new CustomJTextField("Start Date", FIELD_SIZE);
    private CustomJTextField endDate = new CustomJTextField("End Date", FIELD_SIZE);

    // Pointer to client hashmap
    ArrayList<Client> clients;

    // Pointer to clientViewer
    ClientViewer viewer;

    public DataEntry(ClientViewer viewer, ArrayList<Client> clients){

        this.clients = clients;
        this.viewer = viewer;
        populateComboBox(lessons, 51);
        populateComboBox(amountPerLesson, 201);
        populateComboBox(numberOfChildren, 26);
        componentSetup();
        mainPanelSetup();
       
    }

    private void componentSetup(){
        // Component Properties
        addClient.setFont(font);
        addClient.setBorder(new RoundedBorder(5));

        // Add client listener
        addClient.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove all commas
                removeAllCommas();

                // Adds client to viewer and to file
                Client client = new Client(name.getText(), phoneNumber.getText(), address.getText(), startDate.getText(), endDate.getText(), (String)instructorsBox.getSelectedItem(), lessons.getSelectedIndex(), numberOfChildren.getSelectedIndex(), amountPerLesson.getSelectedIndex());
                
                viewer.addClient(client);


                // Add to hashmap as well
                clients.add(client);

                // Read file and store
                try {
                    BufferedWriter write = new BufferedWriter(new FileWriter("ClientTracker\\Data\\clients.txt", true));
                    write.write(client.getFirstName()+","+client.getPhoneNumber()+","+client.getAddress()+","+client.getStartDate()+","+client.getEndDate()+","+instructorsBox.getSelectedItem()+","+client.getNumberOfLessons()+","+client.getNumberOfChildren()+","+client.getAmountPerLesson());
                    write.newLine();
                    write.close();
                } catch (IOException x) {
                    // TODO Auto-generated catch block
                    x.printStackTrace();
                }

                // Reset data
                name.setText("");
                phoneNumber.setText("");
                address.setText("");
                startDate.setText("");
                endDate.setText("");
                numberOfChildren.setSelectedIndex(0);
                lessons.setSelectedIndex(0);
            }

        });

        addClient.setBackground(new Color(146,210,147)); // Nice green color

        // Add components
        namePanel.add(name);
        phoneNumberPanel.add(phoneNumber);
        addressPanel.add(address);
        startDatePanel.add(startDate);
        endDatePanel.add(endDate);
        instructorPanel.add(instructorsBox);
        instructorPanel.add(lessons);
        instructorPanel.add(numberOfChildren);
        instructorPanel.add(amountPerLesson);
        addClientPanel.add(addClient);

        // Combo box options
        instructorsBox.setFont(font);
        numberOfChildren.setFont(font);
        lessons.setFont(font);
        amountPerLesson.setFont(font);

    
        // Set properties
        namePanel.setBackground(Color.WHITE);
        phoneNumberPanel.setBackground(Color.WHITE);
        addressPanel.setBackground(Color.WHITE);
        startDatePanel.setBackground(Color.WHITE);
        endDatePanel.setBackground(Color.WHITE);
        instructorPanel.setBackground(Color.WHITE);
        lessonsPanel.setBackground(Color.WHITE);
        instructorPanel.setBorder(new TitledBorder(new LineBorder(Color.WHITE), "Instructor / Lessons / Children / $", 0, 0, new CustomFont(14)));

        // Lessons title
        lessonsPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Lesson/$ per lesson/# of children", 0, 0, new CustomFont(14)));

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
        this.add(instructorPanel);
        this.add(addClientPanel);
    }

    // Populates JComboBox and sets properties
    private void populateComboBox(JComboBox combo, int maxNumber){
        for (int i = 0; i < maxNumber; i++) {
            combo.addItem(i);
        }
        
        // ComboBox properties
        lessons.setFont(new CustomFont(13));
    
    }

    // Removes all the commas before data is entered so
    // The application does not read incorrect data
    private void removeAllCommas(){
        name.setText(name.getText().replace(',', ' '));
        phoneNumber.setText(phoneNumber.getText().replace(',', ' '));
        address.setText(address.getText().replace(',', ' '));
        startDate.setText(startDate.getText().replace(',', ' '));
        endDate.setText(endDate.getText().replace(',', ' '));
    }
    
}
