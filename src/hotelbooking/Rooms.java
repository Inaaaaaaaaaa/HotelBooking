/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author aimee
 */

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Image;

public class Rooms extends JFrame {
            
        //variables
        private int number_of_adults;
        private int number_of_children;
        public JComboBox<Integer> requested_number_of_rooms;

    
    public Rooms(int adults, int children)
    {
        this.number_of_adults = adults;
        this.number_of_children = children;
        
        //creating frame
        setTitle("Rooms");
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //align images of rooms in the frame
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        
        //number of adults (from search class) ROOM DETAILS
        if(number_of_adults == 1)
        {
            ImageIcon image1 = new ImageIcon("./resources/room1.jpg");
            Image image = image1.getImage();
            Image resizedImage= image.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            
            addRoom(main, "Single Room", "Free wi-fi, 24hr shower access, 1 Bathroom, 1 single bed", "$150", resizedIcon);
        }
        else if(number_of_adults == 2)
        {
            
        }
        else if(number_of_adults == 3)
        {
            
        }
        else if(number_of_adults == 4)
        {
            
        }
        else if(number_of_adults == 5)
        {
            
        }
        else if(number_of_adults == 6)
        {
            
        }
        add(main, BorderLayout.CENTER);
        
        //number of children
    }
    
    
    //add room
    private void addRoom(JPanel main, String roomName, String roomDetails, String roomPrice, ImageIcon roomimage)
    {
        JPanel roomPanel = new JPanel();
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.X_AXIS));
        
        //image
        JLabel image = new JLabel(roomimage);
        roomPanel.add(image);
        
        //spacing for image and details
        roomPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        
        //room details 
        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        
        //labels
        JLabel name = new JLabel(roomName);
        JLabel price = new JLabel(roomPrice);

        //adding labels
        details.add(name);
        details.add(price);
        
        roomPanel.add(details);
        
        //adding main panel to room
        main.add(roomPanel);
    }
    
    //show Rooms frame
    public void showRooms()
    {
        setVisible(true);
    }
   
}
