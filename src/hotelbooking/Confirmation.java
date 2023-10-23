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
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Confirmation extends JFrame implements ActionListener {
    
    private int roomNumber;
    private JLabel labelImage;
    private JLabel RoomName;
    private JLabel RoomDetails;
    private JLabel RoomPrice;
    private JButton confirmationBtn;
    private JButton backBtn;
    private String confirmationStatus;
    private String roomPrice;
    
    public Confirmation(int roomNumber, Roomdata roomdata)
    {
        this.roomNumber = roomNumber;
        this.roomPrice = roomdata.roomPrice;
        
        setTitle("Confirmation");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
      
        //roomprice
        RoomPrice = new JLabel(this.roomPrice);
        
        //southpanel
        JPanel southPanel = new JPanel();
        //confirm and back button
        backBtn = new JButton("Back");
        backBtn.addActionListener(e -> gobacktoroom());
        southPanel.add(backBtn);
        
        confirmationBtn = new JButton("Confirm");
        confirmationBtn.addActionListener(e -> SuccessfulConfirmation());
        southPanel.add(confirmationBtn);
        confirmationStatus = "No";
                
        this.add(southPanel, BorderLayout.SOUTH);
        
        //adding to frame 
        add(labelImage, BorderLayout.CENTER);
        add(RoomName, BorderLayout.NORTH);
        add(RoomDetails);
        add(RoomPrice, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == confirmationBtn)
        {
            //updates status to yes in .txt file
            confirmationStatus = "Yes";
            updateConfirmation();
        }
    }
    
    private void updateConfirmation()
    {
        //update in text file 
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt")))
        {
            writer.write("Confirmation status: " + confirmationStatus);
            writer.newLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void showConfirmation()
    {
        setVisible(true);
    }
    
    public void SuccessfulConfirmation()
    {
        JOptionPane.showMessageDialog(this,"Booking has been confirmed succesfully :D Thank you for booking with us!");
        //set frame as visible 
        setVisible(true);
    }

    public void gobacktoroom()
    {
        Rooms room = new Rooms(1,1,1,1);
        room.setVisible(true);
        this.dispose();
        
    }
}
