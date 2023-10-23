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
import java.awt.Image;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Rooms extends JFrame {
            
        //variables
        private int number_of_adults;
        private int number_of_children;
        private int number_of_doublerooms;
        private int number_of_singlerooms;
        private int roomNumber;
        private static final int Image_width = 300;
        private static final int Image_height = 300;
        public JComboBox<Integer> requested_number_of_rooms;
        private List<Roomdata> selectedRooms = new ArrayList<>();
        private List<Roomdata> rooms = new ArrayList<>();
        private JButton logoutBtn;
        private JButton selectBtn;
        private JOptionPane invalidInputDialog;
        
        
    public Rooms(int adults, int children, int doublerooms, int singlerooms, int roomNumber)
    {
        this.number_of_adults = adults;
        this.number_of_children = children;
        this.number_of_doublerooms = doublerooms;
        this.number_of_singlerooms = singlerooms;
        this.roomNumber = roomNumber;
        
        //creating frame
        setTitle("Rooms");
        setSize(600,700);
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
                        
        //switch case for number of single rooms
        switch(number_of_singlerooms)
        {
            ///single room
            case 1:
                if((number_of_children == 1 && number_of_adults == 0) 
                  || (number_of_adults == 1 && number_of_children == 0)
                  || (number_of_adults == 1 && number_of_children == 1))  
                {
                //takes the room details from Roomdata and displays it in a new frame -> single rooms only
                Roomdata.RoomManager manager1 = new Roomdata.RoomManager();
                rooms = manager1.getSingleRooms();
                }
                break;
                
                //2 single rooms
            case 2:
                if((number_of_adults == 2 && number_of_children == 0)
                  ||(number_of_adults == 1 && number_of_children == 2)
                  ||(number_of_adults == 2 && number_of_children == 1)
                  ||(number_of_adults == 2 && number_of_children == 2))
                {
                    Roomdata.RoomManager manager2 = new Roomdata.RoomManager();
                    rooms = manager2.getSingleRooms();
                }
                break;
                
            //3 single rooms
            case 3:
                if((number_of_adults == 3 && number_of_children == 0)
                        || (number_of_adults == 2 && number_of_children == 1)
                        || (number_of_adults == 1 && number_of_children == 2)
                        || (number_of_adults == 0 && number_of_children == 3)
                        || (number_of_adults == 2 && number_of_children == 0)
                        || (number_of_adults == 1 && number_of_children == 1))
                {
                    Roomdata.RoomManager manager3 = new Roomdata.RoomManager();
                    rooms = manager3.getSingleRooms();
                }
                break;
                
            //4 single rooms
            case 4:
                if((number_of_adults == 4 && number_of_children == 0)
                        || (number_of_adults == 3 && number_of_children == 1) 
                        || (number_of_adults == 2 && number_of_children == 2)
                        || (number_of_adults == 1 && number_of_children == 3)
                        || (number_of_adults == 0 && number_of_children == 4))
                {
                    Roomdata.RoomManager manager4 = new Roomdata.RoomManager();
                    rooms = manager4.getSingleRooms();
                }
                break;
                
            //5 single rooms
            case 5:
                if((number_of_adults == 5 && number_of_children == 0)
                        || (number_of_adults == 4 && number_of_children == 1) 
                        || (number_of_adults == 3 && number_of_children == 2)
                        || (number_of_adults == 2 && number_of_children == 3)
                        || (number_of_adults == 1 && number_of_children == 4)
                        || (number_of_adults == 0 && number_of_children == 5))
                {
                    Roomdata.RoomManager manager5 = new Roomdata.RoomManager();
                    rooms = manager5.getSingleRooms();
                }
                break;
                
            //6 single rooms
            case 6:
                if((number_of_adults == 6 && number_of_children == 0)
                        || (number_of_adults == 5 && number_of_children == 1) 
                        || (number_of_adults == 4 && number_of_children == 2)
                        || (number_of_adults == 3 && number_of_children == 3)
                        || (number_of_adults == 2 && number_of_children == 4)
                        || (number_of_adults == 1 && number_of_children == 5)
                        || (number_of_adults == 0 && number_of_children == 6))
                {
                    Roomdata.RoomManager manager6 = new Roomdata.RoomManager();
                    rooms = manager6.getSingleRooms();
                }
                break;
            //7 single rooms
            default:
                JOptionPane.showMessageDialog(this, "Invalid input! Please try again!");
                break;
        }
        
        switch(number_of_doublerooms)
        {
            case 1:
                if((number_of_adults == 2 && number_of_children == 0) 
                        || (number_of_adults == 1 && number_of_children == 1)
                        || (number_of_adults == 2 && number_of_children == 1)
                        || (number_of_adults == 2 && number_of_children == 2)
                        || (number_of_adults == 1 && number_of_children == 2)
                        || (number_of_adults == 0 && number_of_children == 2))
                {
                    Roomdata.RoomManager manager = new Roomdata.RoomManager();
                    rooms = manager.getDoubleRooms();
                }
                break;
                
            default:
                  invalidInputDialog = new JOptionPane( "Invalid input! Please try again!");
                  JDialog dialog = invalidInputDialog.createDialog("Invalid input");
                  dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                  
                  //button for user to close the dialog 
                  JButton okayBtn = new JButton("Okay");
                  okayBtn.addActionListener(e -> { dialog.setVisible(false); dialog.dispose();
                          });
                  
                  showRooms();
                break;
        }
               
        for(Roomdata data : rooms)
        {
            //displays multiple images underneath eachother 
            ImageIcon images = new ImageIcon(data.roomImage);
            Image image = images.getImage();
            
            double scale = Math.min((double) Image_width / image.getWidth(null), (double) Image_height / image.getHeight(null));
            int newWidth = (int) (image.getWidth(null) * scale);
            int newHeight = (int) (image.getHeight(null) * scale);
            
            Image resizedImage = image.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
                  
            //select button (shows on every picture)
            JPanel corner = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            selectBtn = new JButton("Select");
            selectBtn.addActionListener(e -> displayRoom());
            corner.add(selectBtn);
            this.add(corner, BorderLayout.EAST);
            
            //adding everything such as name, details, price and select button in room frame 
            addRoom(main, data.roomName, data.roomDetails, data.roomPrice, resizedIcon, selectBtn);              
        }
        
       //adding layout and reprinting images 
       JScrollPane scroll = new JScrollPane(main);
       add(scroll, BorderLayout.EAST);
       main.revalidate(); //chatGPT
       main.repaint();
    }
    //get and set methods
    public int getRoomNumber()
    {
        return roomNumber;
    }
    
    public int getSingleRoom()
    {
        return number_of_singlerooms;
    }
    
    public int getDoubleRoom()
    {
        return number_of_doublerooms;
    }
    //adding rooms -> new frames
    private void addRoom(JPanel main, String roomName, String roomDetails, String roomPrice, ImageIcon roomimage, JButton selectBtn)
    {
        JPanel roomPanel = new JPanel();
        GridBagConstraints constraints = new GridBagConstraints(); //chatGPT
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST; //chatGPT
        JLabel image = new JLabel(roomimage);
        roomPanel.add(image, constraints);
             
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
        
        constraints.gridx = 1;
        roomPanel.add(details, constraints);
        
        constraints.gridx = 2;
        
        //adding button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(selectBtn);
        roomPanel.add(buttonPanel, constraints);
        
        //combo box for room count
        JComboBox<Integer> roomcount = new JComboBox<>();
        
        for(int index = 1; index <= 6; index++)
        {
            roomcount.addItem(index);
        }
        buttonPanel.add(roomcount);
        buttonPanel.add(selectBtn);
        
        selectBtn.addActionListener(e -> {
        int roomselected = (Integer) roomcount.getSelectedItem();
        Roomdata selectedRoom = new Roomdata(roomNumber, "hi", roomName, roomDetails, roomPrice);
        selectedRooms.add(selectedRoom);
        displayRoom();
                });
        
        roomPanel.add(buttonPanel, constraints);
        //adding main panel to room
        main.add(roomPanel);
    }
    
    //room number selection 
    private void displayRoom()
    {
        for(Roomdata selectedRoom : selectedRooms)
        {
            Confirmation confirmations = new Confirmation(selectedRoom.roomNumber, selectedRoom.roomImage, selectedRoom.roomName, selectedRoom.roomDetails, selectedRoom.roomPrice);
            confirmations.showConfirmation();
        }
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
            Rooms roomsFrame = new Rooms(number_of_adults, number_of_children, number_of_doublerooms, number_of_singlerooms, roomNumber);
            roomsFrame.showRooms();
            setVisible(true);
    }
}
