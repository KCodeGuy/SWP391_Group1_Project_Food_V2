package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.ProductStatus;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class ProductDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

    /**
     * Function get list product
     *
     * This function use to take all products in a condition other than REMOVED
     * to upload to the home page
     *
     * @return List<Product> list of product
     */
    public List<Product> getListProduct() {
        try {
            String query = "SELECT * FROM [PRODUCT] P join [CATEGORY] C ON P.CategoryID = C.CategoryID\n"
                    + "WHERE P.ProductStatus <> 'REMOVED'"; //query select product orther than REMOVED
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery(); // the same with click to "excute" btn;
            List<Product> list = new ArrayList<>(); //list product
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2), 
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        ProductStatus.valueOf(rs.getString(6)),
                        rs.getString(7),
                        rs.getString(9))
                ); // add new item in list
            } // end while rs.next
            return list;// return list product
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
//    
//    public static void main(String[] args) {
//        ProductDAO pdao = new ProductDAO();
//        List<Product> listProduct = pdao.getListProduct();
//        for(Product product : listProduct) {
//            System.out.println(product.getProductID()); 
//        }
//        System.out.println(listProduct.size());
//    }
}
