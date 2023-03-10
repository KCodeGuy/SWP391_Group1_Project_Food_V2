package emailHandler;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Random;

/**
 *
 * @author PC
 */
public class EmailHandler {

    /**
     * Function create verification code for authentication email when register
     * @return verification code with 6 random digits(String).
     */
    public String generateRandomCode() {
        Random r = new Random();
        int number = r.nextInt(999999);
        return String.format("%06d", number);
    }
    
    /**
     * To get current date to added into database. 
     * @return a current date to added into database(String)
     */
    public String getTodayDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.valueOf(today.format(formatter));
    }
    
    /**
     * Function verify customer email
     * @param toEmail email of customer
     * @param randomCode verification code sent to customer
     * @return completion or not completion
     */
    public boolean sendEmailAuthen(String toEmail, String randomCode) {
        final String formEmail = "group1shop.fpt@gmail.com";
        final String password = "gzqoghcnqnoqmsxa";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(formEmail, password);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setHeader("Content-Type", "text/plain; charset=UTF-8");
            mimeMessage.setFrom(new InternetAddress(formEmail));
            mimeMessage.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            mimeMessage.setSubject("[G1-FOOD] X??C TH???C ?????A CH??? EMAIL", "utf-8");
            mimeMessage.setContent("<h4>Xin Ch??o <b>" + toEmail + "</b>,</h4>"
                    + "\n<h4>B???n vui l??ng ??i???n m?? x??c th???c email ????? ho??n t???t ????ng k?? t??i kho???n. </h4>"
                    + "\n<h4>M?? x??c th???c 6 s??? c???a b???n l??: <font color=red> " + randomCode + "</font></h4>"
                    + "\n<br><h4>Tr??n tr???ng,</h4>"
                    + "\n<h4>G1-FOOD</h4>",
                    "text/html; charset=UTF-8");

            Transport.send(mimeMessage);

            System.out.println("Done");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Function notice of successful order
     *
     * @param fulllName name of user
     * @param toEmail email of user
     * @param phone phone of user
     * @param address address of user
     * @param oID id of ordering
     * @param status status of ordering
     * @param quantity quantity of ordering
     * @param shipFee fee of ship
     * @param total total order value
     */
    public void sendEmailOrderSuccess(String fulllName, String toEmail, String phone, String address, String oID, String status, int quantity, long total) {
        final String formEmail = "group1shop.fpt@gmail.com";
        final String password = "gzqoghcnqnoqmsxa";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(formEmail, password);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setHeader("Content-Type", "text/plain; charset=UTF-8");
            mimeMessage.setFrom(new InternetAddress(formEmail));
            mimeMessage.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            mimeMessage.setSubject("[G1-FOOD] ?????T H??NG TH??NH C??NG", "utf-8");
            mimeMessage.setContent("<span>Xin Ch??o <b>" + fulllName + ",</b></span>"
                    + "<span> G1-FOOD store x??c nh???n ????n h??ng c???a qu?? kh??ch ???? ???????c ?????t th??nh c??ng. </span>"
                    + "<h4>#Th??ng tin kh??ch h??ng:</h4>"
                    + "_T??n kh??ch h??ng: " + fulllName
                    + "<br>_S??? ??i???n tho???i: " + phone
                    + "<br>_Email: " + toEmail
                    + "<br>_??ia ch???: " + address
                    + "<h4>#Th??ng tin ????n h??ng:</h4>"
                    + "_M?? ????n h??ng: " + oID
                    + "<br>_Tr???ng th??i: " + status
                    + "<br>_S??? l?????ng s???n ph???m: " + quantity
                    + "<br>_Ph?? v???n chuy???n: " + 0 + " ??"
                    + "<br>_H??nh th???c thanh to??n: Ship code(Thanh to??n khi nh???n h??ng)"
                    + "<br><span>_T???ng ti???n: <b><font color=red> " + (total) + " ??</font></b></span><br>"
                    + "<br><span>G1-FOOD r???t c???m ??n qu?? kh??ch ???? tin t?????ng v?? ?????t h??ng. ????n h??ng s??? ???????c x??? l?? v?? giao ?????n qu?? kh??c trong ??t ph??t."
                    + " L??u ??: M???i th???c m???c c???n t?? v???n v??? s???n ph???m hay ????n h??ng. Xin vui l??ng li??n h??? <b>Hotline: 0933.782.768.</b></h4>"
                    + "<h4>Tr??n tr???ng,</span>"
                    + "<h4>G1-FOOD</h4>",
                    "text/html; charset=UTF-8");

            Transport.send(mimeMessage);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
