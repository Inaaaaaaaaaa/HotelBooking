/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author aimee
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Search extends JFrame implements ActionListener {
    
    //variables
    private JFrame search;
    public JComboBox<Integer> number_of_adults;
    public JComboBox<Integer> number_of_children;
    public JButton nextBtn;
    private JButton logoutBtn;
    
    public Search()
    {
        //title of frame
        super ("Search");
 
        //initialize components
        Components();
        Panels();
        
        //size of frame
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    //show search frame
    public void showSearch()
    {
        setVisible(true);
    }
    
    public void Components()
    {
        //number of adults
        this.number_of_adults = new JComboBox<>();  
        for(int index = 0; index <= 6; index++)
        {
            this.number_of_adults.addItem(index);
        }
        
        //number of children
        this.number_of_children = new JComboBox<>();  
        for(int index = 0; index <= 6; index++)
        {
            this.number_of_children.addItem(index);
        }
       
    }
    
    public void Panels()
    {
        //North Panel -> labels
        JPanel centerPanel = new JPanel();
        
        JLabel sign = new JLabel("Welcome to hotel name! To get started, please choose the number of adults/children below.");
        centerPanel.add(sign);
        
        //adult
        JLabel adultLabel = new JLabel("Number of adults: ");
        centerPanel.add(adultLabel);
        centerPanel.add(this.number_of_adults);
        
        //children
        JLabel childLabel = new JLabel("Number of children: ");
        centerPanel.add(childLabel);
        centerPanel.add(this.number_of_children);
        
        this.add(centerPanel, BorderLayout.CENTER);
        
        //south panel
        JPanel southPanel = new JPanel();
        
        //back button
        logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(e -> logout());
        southPanel.add(logoutBtn);
        
        //next button
        nextBtn = new JButton("Next");
        nextBtn.addActionListener(e -> Rooms());
        southPanel.add(nextBtn);
       
        this.add(southPanel, BorderLayout.SOUTH);
        
    }
   
    
    public void initActionListener() 
    {
        //adding number of adults&children to actionlistener
       this.number_of_adults.addActionListener(this);
       this.number_of_children.addActionListener(this);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.number_of_adults || e.getSource() == this.number_of_children) {
            
            this.number_of_adults.getSelectedItem().toString();
            this.number_of_children.getSelectedItem().toString();
        }
    }  
    
    //show room frame : SAVING INFORMATION INTO .TXT FILE
    public void Rooms()
    {
        //saving informtion of number of adults and children 
        int adults = (int) this.number_of_adults.getSelectedItem();
        int children = (int) this.number_of_children.getSelectedItem();
        
        //save to user.txt
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt", true)))
        {
            writer.write("Number of adults: " + adults);
            writer.newLine();
            writer.write("Number of children: " + children);
            writer.newLine();
            //line breaker
            writer.write("--------------------");
            writer.newLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        Rooms show = new Rooms(adults, children);
        show.showRooms();
        this.dispose();
    }
    
    //Login frame set to visible
    public void logout()
    {
        Login logins = new Login();
        logins.setVisible(true);
        this.dispose();
    }
         
 }
