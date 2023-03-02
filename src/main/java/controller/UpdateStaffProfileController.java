/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author GROUP 1
 */
public class UpdateStaffProfileController extends HttpServlet {

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
            out.println("<title>Servlet UpdateStaffProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStaffProfile at " + request.getContextPath() + "</h1>");
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
        //Set the account ID to retrieve the staff 
        String accountID = request.getParameter("accountID");
        //Create a new StaffDAO instance and retrieve the staff with the specified account ID
        AccountDAO sdao = new AccountDAO();
        Account staff = sdao.getStaffByAccountID(accountID);
        //Set the staff and accountID attribute for the request and forward to the updateStaffProfile.jsp page
        request.setAttribute("staff", staff);
        request.setAttribute("accountID", accountID);
        //Forward the request and response objects to the updateStaffProfile.jsp view for display.
        request.getRequestDispatcher("updateStaffProfile.jsp").forward(request, response);
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
        String accountID = request.getParameter("id");
        String accountName = request.getParameter("name");
        String accountPhone = request.getParameter("phone");
        String accountEmail = request.getParameter("email");
        String accountAddress = request.getParameter("address");
        String accountStartDay = request.getParameter("start-date");
        String roleDescription = request.getParameter("role");
        //Create a StaffDAO object and update user profile using retrieved form data
        AccountDAO sdao = new AccountDAO();
        sdao.updateStaffProfile(accountID, accountName, accountPhone, accountAddress, accountStartDay,roleDescription);
        //Redirect staff to the staff profile page with the updated accountID
        request.setAttribute("email", accountEmail);
        //Forward the request and response objects to the updateStaffProfile.jsp view for display.
        request.getRequestDispatcher("staff-profile?accountID=" + accountID).forward(request, response);
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
