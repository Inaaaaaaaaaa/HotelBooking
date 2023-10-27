/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author aimee
 */
/*
Room frame where it display an image where user is able to chose how many adults/children and single rooms 
they would like to book. 
*/
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.Image;

public class Rooms extends JFrame {
            
        //variables - private 
        private int number_of_adults;
        private int number_of_children;
        private int number_of_singlerooms;
        private int roomNumber;
        
        //variables - public 
        public String roomImage;
        public String roomName;
        public String roomDetails;
        public String roomPrice;
        public int count = 1;
        
        //variables static 
        private static final int Image_width = 300;
        private static final int Image_height = 300;
        
        //variables Combo box
        public JComboBox<Integer> requested_number_of_rooms;
        
        //variables Lists
        private List<Roomdata> selectedRooms = new ArrayList<>();
        private List<Roomdata> rooms = new ArrayList<>();
        
        //variables Buttons
        private JButton logoutBtn;
        private JButton selectBtn;
        
        //variables pane
        private JOptionPane invalidInputDialog;
        
        //get and set methods
    public int getRoomNumber()
    {
        return roomNumber;
    }
    
    public int getSingleRoom()
    {
        return number_of_singlerooms;
    }
    
    public Rooms(int adults, int children, int singlerooms)
    {
        this.number_of_adults = adults;
        this.number_of_children = children;
        this.number_of_singlerooms = singlerooms;
        
        //creating frame
        setTitle("Rooms");
        setSize(600,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //back button and north panel -> logout button is placed on the right hand corner of the frame
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
                  invalidInputDialog = new JOptionPane("");
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
        
        for(int index = 0; index <= 6; index++)
        {
            //adding combobox 
            roomcount.addItem(index);
        }
        buttonPanel.add(roomcount);
        buttonPanel.add(selectBtn);
        //select button -> on every single image for rooms selection
        selectBtn.addActionListener(e -> {
        int roomselected = (Integer) roomcount.getSelectedItem();
        Roomdata selectedRoom = new Roomdata(roomNumber, roomImage, roomName, roomDetails, roomPrice);
        
        //checks if room is in list
        boolean exists = false;
        for(Roomdata room : selectedRooms)
        {
            if(room.roomNumber == selectedRoom.roomNumber)
            {
                //incease count of rooms selected
                room.count += roomselected;
                exists = true;
                break;
            }
        }
        if(!exists)
        {
            selectedRoom.count = roomselected;
            selectedRooms.add(selectedRoom);
        }
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
            Confirmation confirmations = new Confirmation(selectedRoom.roomNumber, selectedRoom);
            confirmations.showConfirmation();
            this.dispose();
        }
    }
    
    //logout frame
    public void logout()
    {
        Login logins = new Login();
        logins.setVisible(true);
        this.dispose();
    }
    
    //booking frame
    public void booking()
    {
        Booking bookings = new Booking();
        bookings.setVisible(true);
        this.dispose();
    }
   
    //show Rooms frame for single frame
    public void showRooms()
    {
            Rooms roomsFrame = new Rooms(number_of_adults, number_of_children, number_of_singlerooms);
            roomsFrame.showRooms();
            setVisible(true);
    }
}
