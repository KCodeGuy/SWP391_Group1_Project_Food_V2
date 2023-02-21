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
public class ProductDAOTest {
    ProductDAO pdao;
    public ProductDAOTest() {
        pdao = new ProductDAO();
    }

    @Test
    public void testGetListProduct() {
    }

    @Test
    public void testGetListProductManagePage() {
    }

    @Test
    public void testGetProductByProductID() {
         assertNotNull(pdao.getProductByProductID(1));
    }
    
     @Test
    public void testGetProductByProductID1() {
         assertEquals(pdao.getProductByProductID(1).getProductName(), "Phở Hà Nội");
    }
}
