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
import java.awt.*;

public class Rooms extends JFrame {
            
        //variables
        private int number_of_adults;
        private int number_of_children;
        public JComboBox<Integer> requested_number_of_rooms;
        private JButton logoutBtn;
        private JButton selectBtn;
    
    public Rooms(int adults, int children)
    {
        this.number_of_adults = adults;
        this.number_of_children = children;
        
        //creating frame
        setTitle("Rooms");
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //back button and north panel -> logout button is placed on the right hand corner of the fra,e
        JPanel cornerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); //FlowLayout -> chatGPT
        logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(e -> logout());
        cornerPanel.add(logoutBtn);
        this.add(cornerPanel, BorderLayout.NORTH);
        
        //align images of rooms in the frame
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        
        //number of adults (from search class) ROOM DETAILS
        if(number_of_adults == 1)
        {
            //room 1
            ImageIcon image1 = new ImageIcon("./resources/room1.png");
            Image image = image1.getImage();
            Image resizedImage= image.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
               
            //<html> chatGPT
            addRoom(main, "Single Room", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>-1 single bed<br>-Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>",
                    "Price: $150", resizedIcon);
            
            //select button
            JPanel corner = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            selectBtn = new JButton("Select");
            selectBtn.addActionListener(e -> booking());
            corner.add(selectBtn);
            this.add(corner, BorderLayout.EAST);
            
            //room 2 
            
            
            //room 3
            
            //room 4
            
            
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
        
        //image and button panel
        JLabel image = new JLabel(roomimage);
        roomPanel.add(image);
             
        //spacing for image and details
        roomPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        
        //labels
        JLabel name = new JLabel(roomName);
        JLabel price = new JLabel(roomPrice);
        JLabel roomdescription = new JLabel(roomDetails);
        
        //room detail panel
        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));

        //adding labels
        details.add(name);
        details.add(roomdescription);
        details.add(price);
        
        roomPanel.add(details);
        
        //adding main panel to room
        main.add(roomPanel);
    }
    
    //logout 
    public void logout()
    {
        Login logins = new Login();
        logins.setVisible(true);
        this.dispose();
    }
    
    //booking 
    public void booking()
    {
        Booking bookings = new Booking();
        bookings.setVisible(true);
        this.dispose();
        
    }
   
    //show Rooms frame
    public void showRooms()
    {
        setVisible(true);
    }
   
}
