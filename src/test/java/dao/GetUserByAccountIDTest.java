/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tran Thi Ngoc Hieu CE161025
 */
public class GetUserByAccountIDTest {
    UserDAO udao;
    
     /**
     * Constructor to create a new UserDAO object.
     */
    public GetUserByAccountIDTest() {
        udao = new UserDAO();
    }

     /**
     * Test to check if a user can be retrieved by their account ID.
     * The test will pass if the user is not null.
     */
    @Test
    public void testGetUserByAccountID() {
        assertNotNull(udao.getUserByAccountID(5));
    }
    
    /**
     * Test to check if a null user is returned when an invalid account ID is provided.
     * The test will pass if the user is null.
     */
    @Test
    public void testGetUserByAccountID1() {
        assertNull(udao.getUserByAccountID(8));
    }
    
      /**
     * Test to check if the correct user is returned when a valid account ID is provided.
     * The test will pass if the user's account name matches the expected value.
     */
    @Test
    public void testGetUserByAccountID2() {
        assertEquals(udao.getUserByAccountID(5).getAccountName(), "Lê Văn G1");
    }
}
