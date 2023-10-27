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
/*
Basic login where user and create/register an account 
*/

public class Login extends JFrame {

    //variables
    public JButton loginBtn;
    public JButton registerBtn;
    public JTextField usernameF;
    public JPasswordField passwordF;
    private String singleRoom;
    private String doubleRoom;
    private int roomNumber;

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
        
        int loginstat = isValidLogin(username, password);
        
        switch(loginstat)
        {
            case 1:
                Search searchFrame = new Search();
                searchFrame.setVisible(true);
                this.dispose();
                break;
            case 2:
                //confirmation frame
                JOptionPane.showMessageDialog(this, "You have logged in successfully :)");
                this.dispose();
                Search search1 = new Search();
                search1.showSearch();
                break;
                
            default:
                JOptionPane.showMessageDialog(this, "Details were not found! Please try again or register an account!");
                usernameF.setText("");
                passwordF.setText("");
                break;
        }
    }

    //regiser user -> test case 1 
    public void registerUser(String username, String password)
    {
        LoginDB userDB = new LoginDB();
        
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
            
            // add users into database
            userDB.registerUserDB(username, password);
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(this, "Unsuccessful! Please try again!");
            e.printStackTrace();
        }
        userDB.closeConnection();
    }
    
    //check valid login
    public int isValidLogin(String username, String password) {
        try {
            // Read each line in user.txt
            for (String line : Files.readAllLines(Paths.get("user.txt"))) {
                // Split on " : " to get username and password
                String[] lines = line.split(" : ");
                if (lines.length >= 2 && lines[0].equals(username) && lines[1].equals(password)) {
                    // User found with matching username and password
                    if (lines.length > 4 && "0".equals(lines[2]) && "none".equals(lines[3]) && "none".equals(lines[4])) {
                        // User found but has not made any selections
                        return 1; 
                    } else {
                        return 2;  // Handle cases where there might be additional info but it's not "0", "none", "none"
                    }
                }
            }
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
        // User not found
        return 0;
    }
}