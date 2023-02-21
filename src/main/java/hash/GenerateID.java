/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class GenerateID {

    /**
     * Generate ID by format prefix (2 Character) and 4 digit
     * @param prefix 2 Character
     * @param lastAcountID last account ID
     * @return new ID
     */
    public String generateNewID(String prefix, String lastAcountID) {
        String newId = "";
        try {
            // Remove prefix from the last employee ID
            int idNumber = Integer.parseInt(lastAcountID.substring(prefix.length()));
            // Increment the ID number
            idNumber++;
            // Format the new ID with the prefix and the incremented ID number
            newId = String.format("%s%04d", prefix, idNumber);
        } catch (NumberFormatException e) {
            // If the last employee ID is not in the correct format, return an error message
            return "Invalid employee ID";
        }
        return newId;
    }

    /**
     * Generate two prefix by product name
     * @param productName Name of product
     * @return two prefix
     */
    public String getPrefixFromProductName(String productName) {
        // Get the first letter of each word in the product name and concatenate them
        String[] words = productName.split(" ");
        String prefix = "";
        for (String word : words) {
            prefix += word.charAt(0);
        }
        // Convert the prefix to uppercase and return it
        return prefix.toUpperCase();
    }
}
