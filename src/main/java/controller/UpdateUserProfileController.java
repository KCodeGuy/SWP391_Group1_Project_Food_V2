/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Tran Thi Ngoc Hieu CE161025
 */
public class UpdateUserProfileController extends HttpServlet {

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
            out.println("<title>Servlet UpdateUserProfileController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateUserProfileController at " + request.getContextPath() + "</h1>");
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
        //Set the account ID to retrieve the user 
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        //Create a new UserDAO instance and retrieve the user with the specified account ID
        UserDAO udao = new UserDAO();
        User user = udao.getUserByAccountID(accountID);
        //Set the user and accountID attribute for the request and forward to the updateUserProfile.jsp page
        request.setAttribute("user", user);
        request.setAttribute("accountID", accountID);
        request.getRequestDispatcher("updateUserProfile.jsp").forward(request, response);
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
         //Retrieve form data from HTTP request parameters
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        String accountName = request.getParameter("name");
        String accountAddress = request.getParameter("address");
        int accountPhone = Integer.parseInt(request.getParameter("phone"));
        String userBirthday = request.getParameter("date-of-birth");
         //Create a UserDAO object and update user profile using retrieved form data
        UserDAO udao = new UserDAO();
        udao.updateUserProfile(accountID, userBirthday, accountName, accountPhone, accountAddress);
        //Redirect user to the user profile page with the updated accountID
        response.sendRedirect("loaduserprofile?accountID=" + accountID);
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
