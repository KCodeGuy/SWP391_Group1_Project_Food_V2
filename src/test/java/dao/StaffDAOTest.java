/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import model.Staff;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CE160438 Le Trung Uol
 */
public class StaffDAOTest {
    StaffDAO sdao ;
    public StaffDAOTest() {
       sdao = new StaffDAO();
    }
    @Test
    public void testGetStaffByAccountID() {
        assertEquals(sdao.getStaffByAccountID(8).getAccountName(),"Lê Văn Shipper");
    }
    
     @Test
    public void testGetStaffByAccountID1() {
        assertNotEquals(sdao.getStaffByAccountID(7).getAccountName(),"Lê Văn Shipper");
    }
    
    
    //Load form application details for admin
    @Test
    public void testGetApplicationFormByAccountID() {
       assertEquals(sdao.getApplicationFormByAccountID(8).getAccountName(),"Lê Văn Shipper");
    }
    
    @Test
    public void testGetApplicationFormByAccountID1() {
       assertEquals(sdao.getApplicationFormByAccountID(8).getAccountEmail(),"shipper1@gmail.com");
    }
   
}
