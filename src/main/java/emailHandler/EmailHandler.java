package emailHandler;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

/**
 *
 * @author PC
 */
public class EmailHandler {

    /**
     * Function create verification code for authentication email when register
     *
     * @return verification code with 6 random digits
     */
    public String generateRandomCode() {
        Random r = new Random();
        int number = r.nextInt(999999);
        return String.format("%06d", number);
    }

    /**
     * Function verify customer email
     *
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
    public void sendEmailOrderSuccess(String fulllName, String toEmail, String phone, String address, String oID, String status, int quantity, int shipFee, long total) {
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
            mimeMessage.setSubject("[Group1Shop] ĐẶT HÀNG THÀNH CÔNG", "utf-8");
            mimeMessage.setContent("<span>Xin Chào <b>" + fulllName + ",</b></span>"
                    + "<span> Group1Shop store xác nhận đơn hàng của quí khách đã được đặt thành công. </span>"
                    + "<h4>#Thông tin khách hàng:</h4>"
                    + "_Tên khách hàng: " + fulllName
                    + "<br>_Số điện thoại: " + phone
                    + "<br>_Email: " + toEmail
                    + "<br>_Đia chỉ: " + address
                    + "<h4>#Thông tin đơn hàng:</h4>"
                    + "_Mã đơn hàng: " + oID
                    + "<br>_Trạng thái: " + status
                    + "<br>_Số lượng sản phẩm: " + quantity
                    + "<br>_Phí vận chuyển: " + shipFee + " đ"
                    + "<br>_Hình thức thanh toán: Ship code(Thanh toán khi nhận hàng)"
                    + "<br><span>_Tổng tiền: <b><font color=red> " + (total + shipFee) + " đ</font></b></span><br>"
                    + "<br><span>Group1Shop rất cảm ơn quí khách đã tin tưởng và đặt hàng. Đơn hàng sẽ được xử lí và giao đến quí khác trong 3-7 ngày."
                    + " Lưu ý: Mọi thắc mắc cần tư vấn về sản phẩm hay đơn hàng. Xin vui lòng liên hệ <b>Hotline: 0933.782.768.</b></h4>"
                    + "<h4>Trân trọng,</span>"
                    + "<h4>Group1Shop</h4>",
                    "text/html; charset=UTF-8");

            Transport.send(mimeMessage);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
