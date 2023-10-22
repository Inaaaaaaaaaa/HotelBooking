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
import java.awt.Image;
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
    public JComboBox<Integer> number_of_doublerooms;
    public JComboBox<Integer> number_of_singlerooms;

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
        
        //number of double rooms
        this.number_of_doublerooms = new JComboBox<>();
        for(int index = 0; index <= 6; index++)
        {
            this.number_of_doublerooms.addItem(index);
        }
        
        //number of single rooms
        this.number_of_singlerooms = new JComboBox<>();
        for(int index = 0; index <= 6; index++)
        {
            this.number_of_singlerooms.addItem(index);
        }
        
    }
    
    public void Panels()
    {
        //North Panel -> labels
        JPanel centerPanel = new JPanel();
        
        JLabel sign1 = new JLabel("Welcome to hotel name!");
        JLabel sign2 = new JLabel("To get started, please choose the number of adults/children below.");
        centerPanel.add(sign1);
        centerPanel.add(sign2);
        
        //adult label
        JLabel adultLabel = new JLabel("Number of adults: ");
        centerPanel.add(adultLabel);
        centerPanel.add(this.number_of_adults);
        
        //children label
        JLabel childLabel = new JLabel("Number of children: ");
        centerPanel.add(childLabel);
        centerPanel.add(this.number_of_children);
        
        //double room label
        JLabel doubleLabel = new JLabel("Number of double rooms: ");
        centerPanel.add(doubleLabel);
        centerPanel.add(this.number_of_doublerooms);
        
        //single room label
        JLabel singleLabel = new JLabel("Number of single rooms: ");
        centerPanel.add(singleLabel);
        centerPanel.add(this.number_of_singlerooms);
        
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
       
        //adding next and back button
        this.add(southPanel, BorderLayout.SOUTH);
        
        //adding image
        ImageIcon image1 = new ImageIcon("./resources/view.jpg");
        Image image = image1.getImage();
        Image resizedImage= image.getScaledInstance(550, 550, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        centerPanel.add(imageLabel);
    }
   
    
    public void initActionListener() 
    {
        //adding number of adults&children to actionlistener
       this.number_of_adults.addActionListener(this);
       this.number_of_children.addActionListener(this);
       this.number_of_doublerooms.addActionListener(this);
       this.number_of_singlerooms.addActionListener(this);
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
        int doublerooms = (int) this.number_of_doublerooms.getSelectedItem();
        int singlerooms = (int) this.number_of_singlerooms.getSelectedItem();
        
        //save to user.txt
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt", true)))
        {
            writer.write("Number of adults: " + adults);
            writer.newLine();
            writer.write("Number of children: " + children);
            writer.newLine();
            writer.write("Number of double rooms: " + doublerooms);
            writer.newLine();
            writer.write("Number of single rooms: " + singlerooms);
            writer.newLine();
            //line breaker
            writer.write("--------------------");
            writer.newLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        Rooms show = new Rooms(adults, children, doublerooms, singlerooms);
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
