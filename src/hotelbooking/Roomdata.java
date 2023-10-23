/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author aimee
 */
import java.util.List;
import java.util.ArrayList;

public class Roomdata {
    
    String roomImage;
    String roomName;
    String roomDetails;
    String roomPrice;
    int roomNumber;
    
    
    public Roomdata(int roomNumber, String roomImage, String roomName, String roomDetails, String roomPrice)
    {
        this.roomNumber = roomNumber;
        this.roomImage = roomImage;
        this.roomName = roomName;
        this.roomDetails = roomDetails;
        this.roomPrice = roomPrice;
    }
    
    //this class is made so it prints out many rooms based on user input 
    public static class RoomManager
    {
        private List<Roomdata> rooms = new ArrayList<>();
        
        //single rooms
        public List<Roomdata> getSingleRooms()
        {
            //room1
           rooms.add(new Roomdata(1, "./resources/room1.png", "Single Bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $100"));
           //room2
           rooms.add(new Roomdata(2, "./resources/room1.png", "Single Bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $100"));
           //room3
           rooms.add(new Roomdata(3, "./resources/room1.png", "Single Bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $100"));

           //room 4
           
           ///room5
           return rooms;
        }
        
        //double rooms
        public List<Roomdata> getDoubleRooms()
        {
            rooms.add(new Roomdata(4, "./resources/room1.png", "Double Bed and 1 single bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $100"));
            rooms.add(new Roomdata(5, "./resources/room3.jpg", "Double Bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>-Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $100"));
           return rooms;
            
        }
        
    } 
}
