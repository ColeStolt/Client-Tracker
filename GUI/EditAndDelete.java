package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

import DataObjects.Client;

// This will get a refrence to a client from the hashmap
// All edits made are made to the hashmap and reflected in the 
// Client viewer

public class EditAndDelete extends JFrame {

    public EditAndDelete(){

        this.setSize(new Dimension(100, 300));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
