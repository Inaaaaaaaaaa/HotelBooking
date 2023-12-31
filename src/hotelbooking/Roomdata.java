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
import java.util.HashMap;
import java.awt.event.ActionEvent;

/*
Rommdata is a place where it displays all the rooms details
*/
public class RoomData {
    
    String roomImage;
    String roomName;
    String roomDetails;
    String roomPrice;
    int roomNumber = 1;
    int count;

    public RoomData(int roomNumber, String roomImage, String roomName, String roomDetails, String roomPrice)
    {
        this.roomNumber = roomNumber;
        this.roomImage = roomImage;
        this.roomName = roomName;
        this.roomDetails = roomDetails;
        this.roomPrice = roomPrice;
    }
    
    //get price from rooms THIS DOES SHOW IN CONFIRMATION FRAME
     public double getPrice()
        {
            return Double.parseDouble(this.roomPrice.replace("Price: $", "").trim());
        }
     
    //this class is made so it prints out many rooms based on user input 
    public static class RoomManager
    {
        private final List<RoomData> rooms;
       
        //initialization
        public RoomManager()
        {
            rooms = new ArrayList<>();
            initializeRooms();
        }
        
        //get method for combo box
        public List<String> getRoomNames()
        {
        List<String> roomNames = new ArrayList<>();
        for(RoomData room : rooms)
        {
            roomNames.add(room.roomName);
        }
        return roomNames;
        }
        
        //when user selects multiple rooms, it adds count 
        public void updateRoomSelection(String roomName, int count)
        {
            roomselectioncount.put(roomName, roomselectioncount.getOrDefault(roomName, 0) + 1);
        }
        
        //adds details of each room in Roomdata frame where user is able to view and select rooms
        public void initializeRooms()
        {
           //room1
           rooms.add(new RoomData(1, "./resources/room1.png", "Room 1 ~ 1 Single Bed", "<html>-Shower access<br>-1 Bathroom<br>Cleaning service<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $50"));
           //room2
           rooms.add(new RoomData(2, "./resources/room2.jpg", "Room 2 ~ 2 Single Beds", "<html>-Limited Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle<br>Beautiful view<br></html>", "Price: $100"));
           //room3
           rooms.add(new RoomData(3, "./resources/room3.jpg", "Room 3 ~ 2 Single Beds", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $150"));
           //room 4
           rooms.add(new RoomData(4, "./resources/room4.jpg", "Room 4 ~ 3 Single Beds", "<html>-Free Wi-Fi<br>-Shower access<br>-2 Bathrooms<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $90"));
           ///room5
           rooms.add(new RoomData(5, "./resources/room5.jpg", "Room 5 ~ 4 Single Beds", "<html>-Free Wi-Fi<br>-Shower access<br>-2 Bathrooms<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $140"));
           //room 6
           rooms.add(new RoomData(6, "./resources/room6.png", "Room 6 ~ 1 Single Bed", "<html>-Free Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $100"));
           //room 7
           rooms.add(new RoomData(7, "./resources/room7.png", "Room 7 ~ 4 Single Beds", "<html>-Free Wi-Fi<br>-Shower access<br>-3 Bathrooms<br>Cleaning service provided<br>-4 Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle<br>-Swimming pool<br>-Free TV<br>-Free breakfast provided</html>", "Price: $150"));
           //room8
           rooms.add(new RoomData(8, "./resources/room8.jpg", "Room 8 ~ 1 Double bed 2 Single Beds", "<html>-Free Wi-Fi<br>-Shower access<br>-2 Bathrooms<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $103"));
           //room9
           rooms.add(new RoomData(9, "./resources/room9.png", "Room 9 ~ 3 Single Bed", "<html>-Free Wi-Fi<br>-Shower access<br>-2 Bathrooms<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle</html>", "Price: $130"));
           //room10
           rooms.add(new RoomData(10, "./resources/room10.jpg", "Room 10 ~ 1 Double bed and 1 single bed", "<html>-Free Unlimited Wi-Fi<br>-Shower access<br>-1 Bathroom<br>Cleaning service provided<br>-Towels<br>-Telephone<br>-Coffee machine<br>-Electric kettle<br>-Swimming pool<br>-Gym access<br>Free lunch buffet</html>", "Price: $170"));
        }
        
       
        //track count room selection
        HashMap<String, Integer> roomselectioncount = new HashMap<>();
        
        //single rooms
        public List<RoomData> getSingleRooms()
        {
           return new ArrayList<>(rooms);
        }
   
        //get room number and its price
        public RoomData getRoomNumbers(int roomNumber)
        {
            for(RoomData room : rooms)
            {
                if(room.roomNumber == roomNumber)
                {
                    return room;
                }
            }
            return null;
        }
        
        //adds total cost of rooms NOT WORKING
        public double getTotal()
        {
            double totalPrice = 0;
            
            for(String roomName : roomselectioncount.keySet())
            {
                int roomNumber = Integer.parseInt(roomName.replaceAll("[^0-9]", "").trim());
                RoomData room = getRoomNumbers(roomNumber);
                
                if(room != null)
                {
                    totalPrice += room.getPrice() * roomselectioncount.get(roomName);
                }
            }
            return totalPrice;
        }
        
        //shows the total price in confirmation frame when user selected rooms (THIS DOESN'T SHOW UP ON ANYTHING - TESTING)
        public void actionPerformed(ActionEvent e)
        {
            double totalPrice = getTotal();
            String message = "Total price is: " + totalPrice;
            
           javax.swing.JOptionPane.showMessageDialog(null, message, "Confirmation", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } 
       
    }
}
