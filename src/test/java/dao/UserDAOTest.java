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
public class UserDAOTest {
    UserDAO udao;
    public UserDAOTest() {
           udao = new UserDAO();
    }

    @Test
    public void testGetUserByAccountID() {
    }

    @Test
    public void testUpdateUserProfile() {
    }

    @Test
    public void testGetListUser() {
    }

    @Test
    public void testDeleteUser() {
    }

    @Test
    public void testGetListUserByName() {
        assertEquals(udao.getListUserByName("i").get(0).getAccountName(), "Ngoc Hieu");
    
    }

    @Test
    public void testGetUserPayingByAccountID() {
    }
    
}
