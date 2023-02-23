/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Product;

/**
 *
 * @author Tran Thi Ngoc Hieu CE161025
 */
public class LoadProductDetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Retrieve the product ID parameter from the request and parse it as an integer.
        String productID = request.getParameter("productID");
        //Create a new instance of the ProductDAO class to access the database.
        ProductDAO pdao = new ProductDAO();
        //Call the getProductByProductID method from the ProductDAO instance to retrieve a Product object with the given ID.
        Product product = pdao.getProductByProductID(productID);
        //Get category ID of a product with given product ID
        String categoryID = pdao.getCategoryIDByProductID(productID);
        //Get the top 4 products in the same category as the given product ID, excluding the given product
        ArrayList<Product> listProduct = pdao.getTop4ProductByCategoryID(categoryID, productID);
        //Set the retrieved Product object as an attribute of the current request object with the key "product".
        request.setAttribute("product", product);
        //Set an attribute of a request object with the ArrayList of products obtained from the previous code snippet
        request.setAttribute("listProduct", listProduct);
        //Forward the request and response objects to the productDetail.jsp view for display.
        request.getRequestDispatcher("productDetail.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
