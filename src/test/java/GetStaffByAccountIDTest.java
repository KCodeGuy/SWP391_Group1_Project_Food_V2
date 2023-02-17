/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
// Import library
import dao.StaffDAO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Group 1
 */
public class GetStaffByAccountIDTest {
    
      StaffDAO sdao;
    
    public GetStaffByAccountIDTest() {
        sdao = new StaffDAO();
    }
    // Test (AccountID) does not exist
    @Test
    public void testGetStaffByAccountID() {
        assertNotNull(sdao.getStaffByAccountID(3));
    }
    // Test (AccountID) exist
     @Test
    public void testGetStaffByAccountID1() {
        assertNull(sdao.getStaffByAccountID(4));
    }
    // Test () is exactly as checked
     @Test
    public void testGetStaffByAccountID2() {
        assertEquals(sdao.getStaffByAccountID(3).getAccountName(), "Lê Văn Shipper");
    }
    
}
