/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package hotelbooking;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JButton;

/**
 *
 * @author aimee
 */
public class SearchTest {
    
    public SearchTest() {
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
     * Test of showSearch method, of class Search.
     */
    @Test
    public void testShowSearch() {
        System.out.println("showSearch");
        Search instance = new Search();
        instance.showSearch();
    }

    /**
     * Test of Components method, of class Search.
     */
    @Test
    public void testComponents() {
        System.out.println("Components");
        Search instance = new Search();
        instance.Components();
    }

    /**
     * Test of Panels method, of class Search.
     */
    @Test
    public void testPanels() {
        System.out.println("Panels");
        Search instance = new Search();
        instance.Panels();
    }

    /**
     * Test of initActionListener method, of class Search.
     */
    @Test
    public void testInitActionListener() {
        System.out.println("initActionListener");
        Search instance = new Search();
        instance.initActionListener();
    }

    /**
     * Test of actionPerformed method, of class Search.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        
        JButton button1 = new JButton("Mock");
        ActionEvent e = new ActionEvent(button1, ActionEvent.ACTION_PERFORMED, "Checking");
        Search instance = new Search();
        instance.actionPerformed(e);
    }

    /**
     * Test of Rooms method, of class Search.
     */
    @Test
    public void testRooms() {
        System.out.println("Rooms");
        Search instance = new Search();
        instance.Rooms();
    }

    /**
     * Test of logout method, of class Search.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        Search instance = new Search();
        instance.logout();
    }
    
}
