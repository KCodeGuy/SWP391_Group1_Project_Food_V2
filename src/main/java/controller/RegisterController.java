package controller;

import dao.AccountDAO;
import emailHandler.EmailHandler;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountStatus;

/**
 *
 * @author PC
 */
public class RegisterController extends HttpServlet {

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
        // Get entered data from form to handle.
        String fullName = request.getParameter("name");     // entered full name of account.
        String phone = request.getParameter("phone");       // entered phone of account.
        String email = request.getParameter("email");       // entered email of account.
        String address = request.getParameter("address");   // entered address of account.
        String password = request.getParameter("password"); // entered password of account.
        String birthday = request.getParameter("birthday"); // entered birthday of account.
        String onPosition = request.getParameter("position");

        EmailHandler eh = new EmailHandler();
        AccountDAO adao = new AccountDAO();
        // get current date to set start date.
        String todayDate = eh.getTodayDate();
        // get id of a secified account by entered email.
        String accountID = adao.getAccountIDByEmail(email);
        boolean checkFeaturePageIsAuthenEmail = true;
        // check whether an account is exist or not by email to hanle
        if (adao.checkAccountIsExist(email)) { // account has been already exist actived status.
            request.setAttribute("accountExistMessage", "Account has been adready exist! Please try again!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {  // account is not exist different with actived status.
            int timeSendFailed = 0;
            // get otp code for verify
            String otpCode = eh.generateRandomCode();
            // check whether an account is null or peding to hanle.
            if (adao.getAccountStatusByEmail(email) == null) { // account is null status - not added in database.
                // insert an account to database.
                if (onPosition.equalsIgnoreCase("chef")) { // position is chef
                    adao.registerFormApplication(fullName, email, password, phone, address, birthday, todayDate, onPosition);
                    checkFeaturePageIsAuthenEmail = false;
                } else if (onPosition.equalsIgnoreCase("shipper")) { // position is shipper
                    adao.registerFormApplication(fullName, email, password, phone, address, birthday, todayDate, onPosition);
                    checkFeaturePageIsAuthenEmail = false;
                } else { // position is null
                    adao.registerAccount(fullName, email, password, phone, address, birthday, todayDate);
                }
            } else if (adao.getAccountStatusByEmail(email).equals(String.valueOf(AccountStatus.PENDING))) { // account is pending status.
                // update account when it is pending status.
                adao.updateAccountIsPending(accountID, birthday, fullName, phone, address, todayDate);
            }
            // send email verify to user with otp-code
            eh.sendEmailAuthen(email, otpCode);
            // check whether postion is chef shipper or null to set feature page on form.
            if (onPosition.equalsIgnoreCase("chef") || onPosition.equalsIgnoreCase("shipper")) { // position is chef or shipper
                 request.setAttribute("featurePage", "FORM-APPLY");
            } else { // position is null
                request.setAttribute("featurePage", "AUTHENEMAIL");
            }
            request.setAttribute("timeSendFailed", timeSendFailed);
            request.setAttribute("email", email);
            request.setAttribute("accountID", adao.getAccountIDByEmail(email));
            request.setAttribute("otpCode", otpCode);
            // forward to emailVerification page.
            request.getRequestDispatcher("emailVerification.jsp").forward(request, response);
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
