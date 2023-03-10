/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class Base64Convert {
    public BufferedImage decodeToImage(String base64String){
 
        try {
            // Create a byte array from the Base64 string
            byte[] imageBytes = Base64.getDecoder().decode(base64String);
            
            // Convert the byte array to a BufferedImage
            ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
            BufferedImage image = ImageIO.read(bis);
            bis.close();
            
            return image;
        } catch (IOException ex) {
            Logger.getLogger(Base64Convert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String encodeToString(BufferedImage image, String formatName) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(image, formatName, bos);
            bos.flush();
            byte[] imageBytes = bos.toByteArray();
            bos.close();
            
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException ex) {
            Logger.getLogger(Base64Convert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
