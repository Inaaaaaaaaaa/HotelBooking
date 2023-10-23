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
     * Test of showRooms method, of class Rooms.
     */
    @Test
    public void testShowRooms() {
        System.out.println("showRooms");
        Rooms instance = new Rooms(1, 2,3,1,0);
        instance.showRooms();
    }

    /**
     * Test of logout method, of class Rooms.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        Rooms instance = new Rooms(1,2,3,1,0);
        instance.logout();
    }

    /**
     * Test of booking method, of class Rooms.
     */
    @Test
    public void testBooking() {
        System.out.println("booking");
        Rooms instance = new Rooms(1,2,3,1,0);
        instance.booking();
    }
    
}
