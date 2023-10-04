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

public class Rooms extends JFrame {
    
    public Rooms()
    {
        //creating frame
        setTitle("Room details");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    //show Rooms frame
    public void showRooms()
    {
        setVisible(true);
    }
    
    
}
