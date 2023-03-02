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
import java.util.List;
import model.Product;
import paging.PagingUtil;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class LoadListProductByCatorogyIDForAdminController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String categoryID = request.getParameter("categoryID");
        int pageNo = 1;
        if (request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        int pageSize = 10;

        ProductDAO pdao = new ProductDAO();
        List<Product> listAllProduct = pdao.getListProductByCategory(categoryID);
        List<Product> listProduct = PagingUtil.getPagingProducts(listAllProduct, pageNo, pageSize); // get list product to load page

        int totalPages = PagingUtil.getTotalPages(listAllProduct, pageSize);

        request.setAttribute("categoryID", categoryID);
        request.setAttribute("page", "category");
        request.setAttribute("totalPages", totalPages);
        if(listProduct.isEmpty()){
            request.setAttribute("MESSAGE", "Product not found!");
        }
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("productQuantity", listAllProduct.size());//show the number of products in the list
        request.getRequestDispatcher("manageProduct.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
