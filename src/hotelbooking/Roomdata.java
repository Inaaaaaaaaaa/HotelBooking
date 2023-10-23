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
import javax.swing.JComboBox;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Roomdata {
    
    String roomImage;
    String roomName;
    String roomDetails;
    String roomPrice;
    int roomNumber;
    int count;

    public Roomdata(int roomNumber, String roomImage, String roomName, String roomDetails, String roomPrice)
    {
        this.roomNumber = roomNumber;
        this.roomImage = roomImage;
        this.roomName = roomName;
        this.roomDetails = roomDetails;
        this.roomPrice = roomPrice;
    }
    
    //get price from rooms
     public double getPrice()
        {
            return Double.parseDouble(this.roomPrice.replace("Price: $", "").trim());
        }
     
    //this class is made so it prints out many rooms based on user input 
    public static class RoomManager
    {
        private List<Roomdata> rooms = new ArrayList<>();
        
        //track count room selection
        HashMap<String, Integer> roomselectioncount = new HashMap<>();
        
        //single rooms
        public List<Roomdata> getSingleRooms()
        {
            //room1
           rooms.add(new Roomdata(1, "./resources/room1.png", "Single Bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $100"));
           //room2
           rooms.add(new Roomdata(2, "./resources/room1.png", "Single Bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $200"));
           //room3
           rooms.add(new Roomdata(3, "./resources/room1.png", "Single Bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $150"));
           //room 4
           rooms.add(new Roomdata(4, "./resources/room1.png", "Single Bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $300"));
           ///room5
           rooms.add(new Roomdata(5, "./resources/room1.png", "Single Bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $100"));
           return rooms;
        }
        
        //double rooms
        public List<Roomdata> getDoubleRooms()
        {
            //room1
            rooms.add(new Roomdata(6, "./resources/room1.png", "Double Bed and 1 single bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $100"));
            //room2
            rooms.add(new Roomdata(7, "./resources/room3.jpg", "Double Bed and 2 single beds", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>-Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $150"));
            //room3
            rooms.add(new Roomdata(8, "./resources/room3.jpg", "3 Double Beds", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>-Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $130"));
            //room4
            rooms.add(new Roomdata(9, "./resources/room3.jpg", "Double Bed and 1 single bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>-Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $200"));
            //room5
            rooms.add(new Roomdata(10, "./resources/room3.jpg", "3 Double Beds", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>-Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $105"));
            //room6
            rooms.add(new Roomdata(11, "./resources/room3.jpg", "2 Double Beds and 1 single bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>-Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $250"));
           return rooms;
        }
        
        //get room number and its price
        public Roomdata getRoomNumbers(int roomNumber)
        {
            for(Roomdata room : rooms)
            {
                if(room.roomNumber == roomNumber)
                {
                    return room;
                }
            }
            return null;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            JComboBox comboBox = (JComboBox) e.getSource();
            String selectedRoom = (String) comboBox.getSelectedItem();
            int selectedIndex = comboBox.getSelectedIndex();
            
            //if index is 0, then set the price to 0
            if(selectedIndex == 0)
            {
                 Roomdata selectedRoomdata = this.getRoomNumbers(Integer.parseInt(selectedRoom));
                 
                 if(selectedRoomdata != null)
                 {
                     //setting price to $0
                     selectedRoomdata.roomPrice = "Price: $0";
                 }
            }
            else
                 {
                     //else if add 1 more every time user selected more than 1 of the same room
                     roomselectioncount.put(selectedRoom, roomselectioncount.getOrDefault(selectedRoom, 0) + 1); 
                     Roomdata selectedRoomdata = this.getRoomNumbers(Integer.parseInt(selectedRoom));
                 }

        }
    } 
}
