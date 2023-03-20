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
 * @author Trần Đăng Khoa
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
            mimeMessage.setSubject("[G1-FOOD] XÁC THỰC ĐỊA CHỈ EMAIL", "utf-8");
            mimeMessage.setContent("<h4>Xin Chào <b>" + toEmail + "</b>,</h4>"
                    + "\n<h4>Bạn vui lòng điền mã xác thực email để hoàn tất đăng kí tài khoản. </h4>"
                    + "\n<h4>Mã xác thực 6 số của bạn là: <font color=red> " + randomCode + "</font></h4>"
                    + "\n<br><h4>Trân trọng,</h4>"
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
     * Function to send email to user when ordered.
     *
     * @param fulllName name of user
     * @param toEmail email of user
     * @param phone phone of user
     * @param address address of user
     * @param oID id of ordering
     * @param status status of ordering
     * @param quantity quantity of ordering
     * @param discount percent of discount by voucher
     * @param total total order price
     */
    public void sendEmailIsOrdered(String fulllName, String toEmail, String phone, String address, String oID, String status, int quantity, int discount, int total) {
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
            mimeMessage.setSubject("[G1-FOOD] XÁC NHẬN ĐẶT HÀNG", "utf-8");
            mimeMessage.setContent("<span>Xin Chào <b>" + fulllName + ",</b></span>"
                    + "<span> G1-FOOD cảm ơn quí khách đã tin tưởng và đặt hàng! Đơn hàng sẽ được xử lí trong ít phút!</span>"
                    + "<h4>#Thông tin khách hàng:</h4>"
                    + "_Tên khách hàng: " + fulllName
                    + "<br>_Số điện thoại: " + phone
                    + "<br>_Email: " + toEmail
                    + "<br>_Đia chỉ: " + address
                    + "<h4>#Thông tin đơn hàng:</h4>"
                    + "_Mã đơn hàng: " + oID
                    + "<br>_Trạng thái: " + status
                    + "<br>_Số lượng sản phẩm: " + quantity
                    + "<br>_Phí vận chuyển: " + 0 + "đ(free-ship)"
                    + "<br>_Giảm giá(voucher): -" + discount + "%"
                    + "<br>_Hình thức thanh toán: Ship code(Thanh toán khi nhận hàng)"
                    + "<br><span>_Tổng tiền: <b><font color=red> " + (total) + "đ</font></b></span><br>"
                    + "<br><span> Đội ngủ nhân viên G1-FOOD sẽ xử lí và giao đến quí khác trong ít phút. Quí khách vui lòng theo dỗi thông tin đơn hàng nhé!"
                    + " Lưu ý: Mọi thắc mắc cần tư vấn về sản phẩm hay đơn hàng. Xin vui lòng liên hệ <b>Hotline: (0292) 730 363.</b></h4>"
                    + "<h4>Trân trọng,</span>"
                    + "<h4>G1-FOOD</h4>",
                    "text/html; charset=UTF-8");

            Transport.send(mimeMessage);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Function notice of successful order (delivered)
     *
     * @param fulllName name of user
     * @param toEmail email of user
     * @param oID id of ordering
     * @param quantity quantity of ordering
     * @param total total order value
     */
    public void sendEmailIsDelivered(String fulllName, String toEmail, String oID , int quantity, long total) {
        final String formEmail = "group1shop.fpt@gmail.com";
        final String password = "gzqoghcnqnoqmsxa";
        System.out.println(fulllName + toEmail);
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
            mimeMessage.setSubject("[G1-FOOD] GIAO HÀNG THÀNH CÔNG", "utf-8");
            mimeMessage.setContent("<span>Cảm ơn <b>" + fulllName + ",</b></span>"
                    + "<span> G1-FOOD xác nhận đơn hàng của quí khách đã được giao thành công!</span>"
                    + "<h4>#Thông tin đơn hàng:</h4>"
                    + "_Mã đơn hàng: " + oID
                    + "<br>_Tên khách hàng: " + fulllName
                    + "<br>_Số lượng sản phẩm: " + quantity
                    + "<br>_Phí vận chuyển: " + 0 + "đ(free-ship)"
                    + "<br>_Hình thức thanh toán: Ship code(Thanh toán khi nhận hàng)"
                    + "<br><span>_Tổng tiền: <b><font color=red> " + (total) + " đ</font></b></span><br>"
                    + "<br>Lưu ý: Mọi thắc mắc cần tư vấn về sản phẩm hay đơn hàng. Xin vui lòng liên hệ <b>Hotline: (0292) 730 363.</b></h4>"
                    + "<h4>Trân trọng,</span>"
                    + "<h4>G1-FOOD</h4>",
                    "text/html; charset=UTF-8");

            Transport.send(mimeMessage);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
