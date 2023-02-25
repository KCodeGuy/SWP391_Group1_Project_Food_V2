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
import model.Product;

/**
 *
 * @author CE160438 _ Le Trung Uol
 */
public class UpdateProductForMangePageController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProductForMangePageController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProductForMangePageController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //Set the productID to retrieve the product  
        String productID = request.getParameter("productID");
        //Create a new ProductDAO instance and retrieve the staff with the specified product ID
        ProductDAO pdao = new ProductDAO();
        Product product = pdao.getProductByProductID(productID);
        //Set the product and productID attribute for the request and forward to the updateProduct.jsp
        request.setAttribute("product", product);
        request.setAttribute("productID", productID);
        //Forward the request and response objects to the updateProduct.jsp to display
        request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
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
           
        String productID = request.getParameter("id");//get data from parameter id
        String productName = request.getParameter("name");//get data from parameter name
        String productDescription = request.getParameter("description");//get data from parameter description
        int productPrice = Integer.parseInt(request.getParameter("price"));//get data from parameter price
        int productSalePercent = Integer.parseInt(request.getParameter("salesoff"));//get data from parameter salesoff
        String productStatus = request.getParameter("status");//get data from parameter status
        String categoryID = request.getParameter("category");//get data from parameter category
        String productImage = request.getParameter("image");//get data from parameter image
        
        ProductDAO pdao = new ProductDAO();// Create a new ProductDAO instance to retrieve infomation
        pdao.updateProduct(productName, productPrice, productSalePercent, productStatus, categoryID, productDescription, productImage, productID);
        response.sendRedirect("loadlistproductformanageproductpage?productID=" + productID);//display the list on the page loadlistproductformanagepage
        
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
