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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Search extends JFrame implements ActionListener {
    
    private JFrame search;
    public JComboBox<Integer> number_of_adults;
    public JComboBox<Integer> number_of_children;
    
    public Search()
    {
        super ("Room");
        
        //initialize components
        Components();
        Panels();
        
        //size of frame
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
    }
    
    public void showSearch()
    {
        setVisible(true);
    }
    
    public void Components()
    {
        //number of adults
        this.number_of_adults = new JComboBox<>();  
        for(int index = 1; index <= 10; index++)
        {
            this.number_of_adults.addItem(index);
        }
        
        //number of children
        this.number_of_children = new JComboBox<>();  
        for(int index = 1; index <= 10; index++)
        {
            this.number_of_children.addItem(index);
        }
    }
    
    public void Panels()
    {
        //North Panel
        JPanel centerPanel = new JPanel();
        JLabel sign = new JLabel("Welcome to hotel name! To get started, please choose the number of adults/children below.");
        centerPanel.add(sign);
        JLabel adultLabel = new JLabel("Number of adults: ");
        JLabel childLabel = new JLabel("Number of children: ");
        centerPanel.add(adultLabel);
        centerPanel.add(this.number_of_adults);
        centerPanel.add(childLabel);
        centerPanel.add(this.number_of_children);
        this.add(centerPanel, BorderLayout.CENTER);
    }
    
    
    public void initActionListener() 
    {
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
            
 }
