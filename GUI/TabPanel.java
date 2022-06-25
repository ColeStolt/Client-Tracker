package GUI;

import java.util.ArrayList;

// Simply holds the panes together in a neat package

import javax.swing.JTabbedPane;

import DataObjects.Client;

public class TabPanel extends JTabbedPane {
    

    public TabPanel(ClientViewer viewer, ArrayList<Client> clients){

        this.addTab("Client", new DataEntry(viewer, clients));
    }

}
