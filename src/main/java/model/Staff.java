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
