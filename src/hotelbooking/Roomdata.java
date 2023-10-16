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
    
    String image;
    String roomName;
    String roomDetails;
    String roomPrice;
    int room_number;

    
    public Roomdata(String image, String roomName, String roomDetails, String roomPrice)
    {
        this.image = image;
        this.roomName = roomName;
        this.roomDetails = roomDetails;
        this.roomPrice = roomPrice;
    }
    
    //this class is made so it prints out many rooms for 1 adult 
    public static class RoomManager
    {
        private List<Roomdata> rooms = new ArrayList<>();
        
        public List<Roomdata> getSingleRooms()
        {
            //room1
           rooms.add(new Roomdata("./resources/room1.png", "Single Room", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>-1 single bed<br>-Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $100"));
           //room2
           rooms.add(new Roomdata("./resources/room1.png", "Single Room", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>-1 single bed<br>-Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $100"));
           //room3
           return rooms;
        }
    }
    
}
