/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author aimee
 */

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

//when user books a room, information will be stored into their account 
public class Booking extends JFrame {
    
    public Booking()
    {
        //title of the frame 
        super("Booking confirmation");
        
        //creating and setting size of new frame
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
   
    //show Booking frame
    public void showBookings()
    {
        setVisible(true);
    }
   
}
