/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author aimee
 */

//when user books a room, this frame shows the user the confirmation of their room and exits
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;


public class Confirmation extends JFrame{
    
    private int roomNumber;
    private JLabel labelImage;
    private JLabel RoomName;
    private JLabel RoomDetails;
    private JLabel RoomPrice;
    
    public Confirmation(int roomNumber, String image, String roomName, String roomDetails, String roomPrice)
    {
        this.roomNumber = roomNumber;
        
        setTitle("Confirmation");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        //displaying room details 
        labelImage = new JLabel(new ImageIcon(image));
        RoomName = new JLabel(roomName);
        RoomDetails = new JLabel(roomDetails);
        RoomPrice = new JLabel(roomPrice);
        
        //adding to frame 
        add(labelImage);
        add(RoomName);
        add(RoomDetails);
        add(RoomPrice);
    }
 
    
    public void showConfirmation()
    {
        setVisible(true);
    }
}
