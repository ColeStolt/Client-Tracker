package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import DataObjects.Client;

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

        One more important note:
            The data structure (a hashmap)
            containing all the clients will
            be created here so it can be passed
            around as needed.
*/

public class MainFrame extends JFrame{


    ArrayList<Client> clients = new ArrayList<Client>();

    // Client viewer panel, left side
    ClientViewer viewer = new ClientViewer(clients);

    public MainFrame(String title, int width, int height, String userName){
        super(title);

        loadHasMap();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(width, height);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(new GeneralInfo(userName), BorderLayout.NORTH);
        this.add(new TabPanel(viewer, clients), BorderLayout.EAST);
        this.add(viewer, BorderLayout.CENTER);

    }

    private void loadHasMap(){
        
        String line = "";
        String[] tokens;

        try {
            // Read file
            BufferedReader read = new BufferedReader(new FileReader("ClientTracker\\Data\\clients.txt"));
            while((line = read.readLine()) != null){

                tokens = line.split(",");

                
                
                for(int i = 0; i < tokens.length; i++){

                    System.out.println(tokens[i]);

                }

                Client client = new Client(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8]));

                clients.add(client);
                viewer.addClient(client);

            }
            System.out.println(clients.size());

            viewer.setClients(clients);
           
            read.close(); // This is done so if a match is not found then
                          // Still close the file
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
