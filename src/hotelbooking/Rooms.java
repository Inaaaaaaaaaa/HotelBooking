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
import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Rooms extends JFrame {
            
        //variables
        private int number_of_adults;
        private int number_of_children;
        public JComboBox<Integer> requested_number_of_rooms;
        private JButton logoutBtn;
        private JButton selectBtn;
        private List<Roomdata> rooms = new ArrayList<>();
        
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
                        
        //switch case
        switch(number_of_adults)
        {
            ///single room
            case 1:
                //if 1 is chosen, it takes the room details form Roomdata and displays it in a new frame 
                Roomdata.RoomManager manager1 = new Roomdata.RoomManager();
                rooms = manager1.getSingleRooms();
                break;
                
                //double room
        }
               
        for(Roomdata data : rooms)
        {
            //displays multiple images underneath eachother 
            ImageIcon images = new ImageIcon(data.image);
            Image image = images.getImage();
            Image resizedImage= image.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
                        
            //select button (shows on every picture)
            JPanel corner = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            selectBtn = new JButton("Select");
            selectBtn.addActionListener(e -> displayRoom(data));
            corner.add(selectBtn);
            this.add(corner, BorderLayout.EAST);
            
            //adding everything such as name, details, price and select button in room frame 
            addRoom(main, data.roomName, data.roomDetails, data.roomPrice, resizedIcon, selectBtn);              
        }
        
       //adding layout and reprinting images 
       add(main, BorderLayout.CENTER);
       main.revalidate(); //chatGPT
       main.repaint();
    }
    
    
    //adding rooms -> new frames
    private void addRoom(JPanel main, String roomName, String roomDetails, String roomPrice, ImageIcon roomimage, JButton selectBtn)
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
        
        //adding button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(selectBtn);
        roomPanel.add(buttonPanel);
        
        //adding main panel to room
        main.add(roomPanel);
    }
    
    //room number selection 
    private void displayRoom(Roomdata selectedRoom)
    {
        JFrame details = new JFrame("Room details");
        details.setSize(500, 500);
        details.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        details.setLocationRelativeTo(null);
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
