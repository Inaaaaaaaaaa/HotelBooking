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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//CHATGPT
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;




public class Confirmation extends JFrame {
    
    private int roomNumber;
    private JLabel labelImage;
    private JLabel RoomName;
    private JLabel RoomDetails;
    private JLabel RoomPrice;
    private JButton confirmationBtn;
    private JButton backBtn;
    private String confirmationStatus = "No";
    private String roomPrice;
    private int count;

    
    public Confirmation(int roomNumber, Roomdata roomdata)
    {
        this.roomNumber = roomNumber;
        this.count = count;
        this.roomPrice = roomdata.roomPrice + count;
        
        setTitle("Confirmation");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
      
        //roomprice
        RoomName = new JLabel("Room number: " + roomNumber);
        RoomPrice = new JLabel(this.roomPrice);
        
        //southpanel
        JPanel southPanel = new JPanel();
        //confirm and back button
        backBtn = new JButton("Back");
        backBtn.addActionListener(e -> gobacktoroom());
        southPanel.add(backBtn);
        
        confirmationBtn = new JButton("Confirm");
        confirmationBtn.addActionListener(e -> 
                {
                    //changes .txt file to Yes 
                    confirmationStatus = "Yes";
                    updateConfirmation();
                    SuccessfulConfirmation();
                });
                southPanel.add(confirmationBtn);
                confirmationStatus = "No";
                
        //adding to frame 
        add(RoomName, BorderLayout.NORTH);
        add(RoomPrice, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
    
    
    private void updateConfirmation() //CHATGPT
    {
        Path file = Paths.get("user.txt");
        
        //read files 
        try
        {
            List<String> lines = Files.readAllLines(file);
                    
        //search for line to replace
       for(int index = lines.size() - 1; index >= 0; index--)
        {
            if(lines.get(index).equals("Confirmation status: No"))
            {
                //changes the line to Yes
                lines.set(index, "Confirmation status: Yes");
                break;
            }
        }
       //write lines back to file
       Files.write(file, lines);
            
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
        Rooms room = new Rooms(1,1,1);
        room.setVisible(true);
        this.dispose();
        
    }
   
}
