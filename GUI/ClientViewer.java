package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import DataObjects.Client;
import DataObjects.CustomFont;
import DataObjects.CustomSearchLabel;

/* this is responsible for showing the clients that were added.
   This will load all the clients added from the client files.
   */

public class ClientViewer extends JPanel {
    
    // Color for jlabel
    private Color lightGreen = new Color(230,230,230);
    private Color differentGreen = new Color(200,200,200);

    // for clients
    private JPanel clientList = new JPanel();
    private JScrollPane scroll = new JScrollPane(clientList);

    // layouts
    private BoxLayout box = new BoxLayout(clientList, BoxLayout.Y_AXIS);

    // Pointer to client list
    ArrayList<Client> clients;

    public ClientViewer(ArrayList<Client> clients){
        
        this.clients = clients;

        GUISetup();

        // Allows for dynamic jscrollpane resizing
        this.setLayout(new BorderLayout());

        this.add(scroll, BorderLayout.CENTER);
    }

    // Setups gui
    private void GUISetup(){
        clientList.setLayout(box);

        
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Speed of scrolling
        scroll.getVerticalScrollBar().setUnitIncrement(16);
    }

    // Adds client to viewer and creates a client
    public void addClient(Client client){
        CustomSearchLabel newClient = new CustomSearchLabel(client.getPhoneNumber());
        newClient.setText( "<html><pre>" + client.getFirstName() + "(" + client.getPhoneNumber() + ")---Total: $(" + client.getNumberOfLessons()*client.getAmountPerLesson()*client.getNumberOfChildren() + ".00)-----------------------------------------------------------------------------------------------<br />" 
                                     + "  Address:          [" + client.getAddress( ) + "]"   + "<br />"
                                     + "  Instructor:       [" + client.getInstructor() + "]" + "<br />"
                                     + "  Start/End Date:    " + client.getStartDate() + " - " + client.getEndDate() + "<br />"
                                     + "  Children ------------ <br />" 
                                     + "        * # of Children (" + client.getNumberOfChildren() + ")<br />" 
                                     + "        * # of lessons (" + client.getNumberOfLessons() + ")<br />" 
                                     + "        * $ per lesson $(" + client.getAmountPerLesson() + ".00)<br />" 
                                     + "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</pre></html>"
        );

        // Initial label values
        newClient.setOpaque(true);
		newClient.setBackground(Color.WHITE);
    
        // Mouselistener
        newClient.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                newClient.setBackground(differentGreen);

                // Opens new window for editing which
                // Uses the phoneNumber of the client
                for(int i = 0; i < clients.size(); i++){
                    if(client.getPhoneNumber() == clients.get(i).getPhoneNumber() && client.getFirstName() == clients.get(i).getFirstName()){
                        clients.remove(clients.get(i));
                        break;
                    }
                }

                // Removes client from the JPanel
                clientList.remove(newClient);

                
                System.out.println("If this");
                
                clientList.revalidate();
                clientList.repaint();

                // Read file and empty
                try {
                    BufferedWriter write = new BufferedWriter(new FileWriter("ClientTracker\\Data\\clients.txt", false));
                    write.write("");
                    write.close();
                } catch (IOException x) {
                // TODO Auto-generated catch block
                    x.printStackTrace();
        
                }

                // Read file and empty
                try {
                    BufferedWriter write = new BufferedWriter(new FileWriter("ClientTracker\\Data\\clients.txt", true));
                    
                    for(int i = 0; i < clients.size();i++){
                        write.write(clients.get(i).getFirstName()+","+
                        clients.get(i).getPhoneNumber()+","+
                        clients.get(i).getAddress()+","+
                        clients.get(i).getStartDate()+","+
                        clients.get(i).getEndDate()+","+
                        clients.get(i).getInstructor()+","+
                        clients.get(i).getNumberOfLessons()+","+
                        clients.get(i).getNumberOfChildren()+","+
                        clients.get(i).getAmountPerLesson());

                        write.newLine();
                    }

                    write.close();
                } catch (IOException z) {
                // TODO Auto-generated catch block
                    z.printStackTrace();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                newClient.setBackground(lightGreen);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                newClient.setBackground(lightGreen);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                newClient.setBackground(Color.WHITE);
            }

        });

        // Uodate client viewer
        newClient.setFont(new CustomFont(20));
		clientList.add(newClient);
		this.revalidate();

    }

    public void setClients(ArrayList<Client> clients){
        this.clients = clients;
    }

}
