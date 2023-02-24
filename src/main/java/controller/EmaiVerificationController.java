package controller;

import dao.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.AccountStatus;

/**
 *
 * @author PC
 */
public class EmaiVerificationController extends HttpServlet {

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
        // Get parameter on input to handle.
        String accountID = request.getParameter("accountID");
        String enteredCode = request.getParameter("enteredCode");
        String originCode = request.getParameter("orginalCode");
        String featurePage = request.getParameter("featurePage");
        int timeSendingFailed = Integer.parseInt(request.getParameter("timeSendFailed")) + 1;
        
        AccountDAO adao = new AccountDAO();
        // get an account by passed.
        Account acc = adao.getAccountByID(accountID);

        // check whehter entered otp-code is matched or not
        if (enteredCode.equals(originCode)) { // opt-code is matched
            // check it is in authen email or update password feature.
            if (featurePage.equalsIgnoreCase("AUTHENEMAIL")) { // authen email feature
                adao.updateAccountStatus(acc.getAccountID(), String.valueOf(AccountStatus.ACTIVED));
                request.setAttribute("registerSuccesMessage", "Register successfully! Please login your account!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else { // update password feature
                request.setAttribute("authenEmailSuccess", "Verify email  successfully! Please enter password!");
                request.setAttribute("email", acc.getAccountEmail());
                request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
            }
        } else { // opt-code is not matched
            // check wrong entering time to back home
            if (timeSendingFailed >= 3) { // wrong entering greater than 3 time then back to home
                response.sendRedirect("home");
            } else { // wrong entering less than 3 time then back to home
                if (featurePage.equalsIgnoreCase("AUTHENEMAIL")) { // authen email feature
                    request.setAttribute("featurePage", "AUTHENEMAIL");
                }else {  // update password feature
                     request.setAttribute("featurePage", "UPDATEPASS");
                }
                request.setAttribute("accountID", accountID);
                request.setAttribute("timeSendFailed", timeSendingFailed);
                request.setAttribute("email", acc.getAccountEmail());
                request.setAttribute("showSendAgainBtn", true);
                request.setAttribute("wrongCodeMessage", "Entered OPT-code is incorect! Please try again!");
                request.getRequestDispatcher("emailVerification.jsp").forward(request, response);
            }
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
