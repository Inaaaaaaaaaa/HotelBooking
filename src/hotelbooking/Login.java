/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author aimee
 */
import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Login extends JFrame {

    //variables
    public JButton loginBtn;
    public JButton registerBtn;
    private JTextField usernameF;
    private JPasswordField passwordF;

    public Login()
    {
        //title of the frame
        super("Hotel Name Login");
        
        //center panel & image
        BGPanel centerPanel = new BGPanel("./resources/hotel.jpg");
        
        //username -> if user has an account
        JLabel UsernameLabel = new JLabel("Username: ");
        UsernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(UsernameLabel);
        usernameF = new JTextField(15);
        centerPanel.add(usernameF);
        
        //password -> if user has an account
        JLabel PasswordLabel = new JLabel("Password: ");
        PasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        centerPanel.add(PasswordLabel);
        passwordF = new JPasswordField(15);
        centerPanel.add(passwordF);
        this.add(centerPanel, BorderLayout.CENTER);
        
        //south panel
        //login button
        JPanel southPanel = new JPanel();
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> login());
        southPanel.add(loginBtn);
        
        //register button
        registerBtn = new JButton("Register");
        registerBtn.addActionListener(e -> registerUser(usernameF.getText(), new String(passwordF.getPassword())));
        southPanel.add(registerBtn);
        
        this.add(southPanel, BorderLayout.SOUTH);
        
        //size of frame
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    //login 
    private void login()
    {
        String username = usernameF.getText();
        String password = new String(passwordF.getPassword());
        
        if(isValidLogin(username, password))
        {
            //successful login
            JOptionPane.showMessageDialog(this, "You have logged in successfully :) ");
            //close login window 
            this.dispose();
            
            //show the search frame
            Search search1 = new Search();
            search1.showSearch();
        }
        else
        {
            //unsuccessful login
            JOptionPane.showMessageDialog(this, "Details were not found in the system! Please register. ");
            //leaves box cleared
            usernameF.setText("");   
            passwordF.setText("");

        }
    }


    //regiser user -> test case 1 
    public void registerUser(String username, String password)
    {
        if(username.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please fill in both username and password");
            return;
        }
        
        //saving user info into user.txt file
        try(BufferedWriter writing = new BufferedWriter(new FileWriter("user.txt", true)))
        {
            writing.write(username + " : " + password);
            writing.newLine();
            JOptionPane.showMessageDialog(this, "Registration successful!");
            
            //leaves box cleared
            usernameF.setText("");   
            passwordF.setText("");
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(this, "Unsuccessful! Please try again!");
            e.printStackTrace();
        }
    }
    
    //check valid login
    public boolean isValidLogin(String username, String password)
    {
        try
        {
            //read line in user.txt
            for (String line : Files.readAllLines(Paths.get("user.txt")))
            {
                //username : password 
                String[] lines = line.split(" : ");
                //checking if login user/password matches what is in the .txt file 
                if(lines.length == 2 && lines[0].equals(username) && lines[1].equals(password))
                {
                    return true;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        //if not found, return false
        return false;
    }
    
    //display login frame
    public static void main(String args[])
    {
        Login cf = new Login();
        cf.setVisible(true);
    }
}

