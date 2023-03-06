/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductDAO;
import dao.ReviewDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import model.Product;
import model.Rating;
import model.Review;

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
        ReviewDAO rdao = new ReviewDAO();
        ArrayList<Review> listReview = rdao.getListReviewByProductID(productID);

        HashMap<Integer, Integer> listRating = new HashMap<>();
        listRating.put(5, 0);
        listRating.put(4, 0);
        listRating.put(3, 0);
        listRating.put(2, 0);
        listRating.put(1, 0);
        if (listReview != null) {
            for (Review r : listReview) {
                switch (r.getRating()) {
                    case 5:
                        listRating.put(5, listRating.get(5) + 1);
                        break;
                    case 4:
                        listRating.put(4, listRating.get(4) + 1);
                        break;
                    case 3:
                        listRating.put(3, listRating.get(3) + 1);
                        break;
                    case 2:
                        listRating.put(2, listRating.get(2) + 1);
                        break;
                    case 1:
                        listRating.put(1, listRating.get(1) + 1);
                        break;
                }
            }
        }

        request.setAttribute("listRating", listRating);
        request.setAttribute("sizeReview", listReview.size());
        request.setAttribute("product", product);
        request.setAttribute("listReview", listReview);
        request.setAttribute("productID", productID);
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
