/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class User extends Account{
    private String userBirthday; // Birthday of the user associated with the account

    /**
     * Constructor default
     */
    public User() {
    }

    /**
     * Constructor with all parameter
     * 
     * @param userBirthday Birthday of the user associated with the account
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
    public User(String userBirthday, int accountID, String accountEmail, String accountPassword, AccountStatus accountStatus, String AccountName, int AccountPhone, String AccountAddress, String roleID, String roleDescription) {
        super(accountID, accountEmail, accountPassword, accountStatus, AccountName, AccountPhone, AccountAddress, roleID, roleDescription);
        this.userBirthday = userBirthday;
    }

    /**
     * Get birthday of the user associated with the account
     * @return userBirthday birthday of the user associated with the account
     */
    public String getUserBirthday() {
        return userBirthday;
    }

    /**
     * Set birthday of the user associated with the account
     * @param userBirthday birthday of the user associated with the account
     */
    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    

}
