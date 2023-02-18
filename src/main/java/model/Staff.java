/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class Staff extends Account{

    private String staffStartDate; // Start date of the staff associated with the account

    /**
     * Constructor default
     */
    public Staff() {
    }

    /**
     * Constructor with parameters accountName , accountPhone, accountEmail,
     * accountAddress and roleDescription
     * 
     * @param accountName
     * @param accountPhone
     * @param accountEmail
     * @param accountAddress
     * @param roleDescription 
     */
    public Staff(String accountName, int accountPhone,String accountEmail, String accountAddress, String roleDescription) {
        super(accountEmail, accountName, accountPhone, accountAddress, roleDescription);
    }
    
    /**
     * Constructor with all parameter
     * 
     * @param staffStartDate Start date of the staff associated with the account
     * @param accountID ID of the account
     * @param accountEmail Email address of the account
     * @param accountPassword Password of the account
     * @param accountStatus Status of the account
     * @param roleDescription Description of the role of the account
     * @param AccountName Full name associated with the account
     * @param AccountPhone Phone number associated with the account
     * @param AccountAddress Address associated with the account
     * @param roleID ID of the role associated with the account
     */
    public Staff(String staffStartDate, int accountID, String accountEmail, String accountPassword, AccountStatus accountStatus, String AccountName, int AccountPhone, String AccountAddress, String roleID, String roleDescription) {
        super(accountID, accountEmail, accountPassword, accountStatus, AccountName, AccountPhone, AccountAddress, roleID, roleDescription);
        this.staffStartDate = staffStartDate;
    }

     /**
     *
     * @param string
     * @param aInt
     * @param string0
     * @param i
     * @param string1
     */
    public Staff(String string, int aInt, String string0, int i, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param string
     * @param aInt
     * @param string0
     * @param string1
     */
    public Staff(String string, int aInt, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Constructor with parameter accountName, accountPhone, accountEmail, accountAddress, roleDescription, staffStartDate
     * Constructor use display information of staff
     * @param accountName
     * @param accountPhone
     * @param staffStartDate Start date of the staff associated with the account
     * @param accountAddress
     * @param roleDescription Description of the role of the account
     * @param AccountAddress Address associated with the account
     */
    public Staff(String accountName, int accountPhone, String accountEmail, String accountAddress, String roleDescription,String staffStartDate) {
        super(accountName, accountPhone, accountEmail, accountAddress, roleDescription);
        this.staffStartDate = staffStartDate;
    }
/**
     * Constructor with all account
     * @param accountID ID of the account
     * @param accountEmail Email  of the account
     * @param accountName Name of the account
     * @param roleDescription Role the of account
     */
    public Staff(int accountID, String accountEmail, String accountName, String roleDescription) {
        super(accountID, accountEmail, accountName, roleDescription);
    }
    
    
    /**
     * Get the start date of the staff
     *
     * @return String The start date of the staff
     */
    public String getStaffStartDate() {
        return staffStartDate;
    }

    /**
     * Set the start date of the staff
     *
     * @param staffStartDate The start date of the staff
     */
    public void setStaffStartDate(String staffStartDate) {
        this.staffStartDate = staffStartDate;
    }

}
