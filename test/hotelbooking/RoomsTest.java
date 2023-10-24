/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package hotelbooking;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aimee
 */
public class RoomsTest {
    
    public RoomsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRoomNumber method, of class Rooms.
     */
    @Test
    public void testGetRoomNumber() {
        System.out.println("getRoomNumber");
        Rooms instance = new Rooms(2,5,6);
        int expResult = 0;
        int result = instance.getRoomNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSingleRoom method, of class Rooms.
     */
    @Test
    public void testGetSingleRoom() {
        System.out.println("getSingleRoom");
        Rooms instance = new Rooms(2, 5,6);
        int expResult = 0;
        int result = instance.getSingleRoom();
        assertEquals(expResult, result);
    }

    /**
     * Test of logout method, of class Rooms.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        Rooms instance = new Rooms(2,5,6);
        instance.logout();
    }

    /**
     * Test of booking method, of class Rooms.
     */
    @Test
    public void testBooking() {
        System.out.println("booking");
        Rooms instance = new Rooms(2,5,6);
        instance.booking();
    }

    /**
     * Test of showRooms method, of class Rooms.
     */
    @Test
    public void testShowRooms() {
        System.out.println("showRooms");
        Rooms instance = new Rooms(2,5,6);
        instance.showRooms();
    }
    
}
