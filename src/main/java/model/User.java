/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class User extends Account {

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
     * Constructs a new User object with the specified user birthday, account
     * email, account name, account phone, and account address.
     *
     * @param userBirthday the user's birthday
     * @param accountEmail the account email
     * @param accountName the account name
     * @param accountPhone the account phone number
     * @param accountAddress the account address
     */
    public User(String userBirthday, String accountEmail, String accountName, int accountPhone, String accountAddress) {
        //Call the constructor of the superclass (Account) to initialize the account email, account name, account phone, and account address fields
        super(accountEmail, accountName, accountPhone, accountAddress);
        //Set the user birthday field to the specified value
        this.userBirthday = userBirthday;
    }

    /**
     * Constructs a new User object with the specified user birthday, account
     * email, account name, account phone, and account address.
     *
     * @param accountID the user's ID account
     * @param accountEmail the account email
     * @param accountName the account name
     */
    public User(int accountID, String accountEmail, String accountName) {
        //Call the constructor of the superclass (Account) to initialize the account ID, account email and account name fields
        super(accountID, accountEmail, accountName);
    }
    
    

    /**
     * Constructs a new User object with the specified user birthday, account
     * email,account password , account name, account phone, and account address.
     * 
     * @param userBirthday the user's birthday
     * @param accountEmail the account email
     * @param accountPassword the account password
     * @param accountName the account name
     * @param accountPhone the account phone number
     * @param accountAddress the account address
     */
    public User(String userBirthday, String accountEmail, String accountPassword, String accountName, int accountPhone, String accountAddress) {
        //Call the constructor of the superclass (Account) to initialize the account email, account password, account name, account phone, and account address fields
        super(accountEmail, accountPassword, accountName, accountPhone, accountAddress);
        //Set the user birthday field to the specified value
        this.userBirthday = userBirthday;
    }
    
    

    /**
     * Get birthday of the user associated with the account
     *
     * @return userBirthday birthday of the user associated with the account
     */
    public String getUserBirthday() {
        return userBirthday;
    }

    /**
     * Set birthday of the user associated with the account
     *
     * @param userBirthday birthday of the user associated with the account
     */
    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

}
