/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class Account {

    private String accountID; // ID of account
    private String accountEmail; // Email of account
    private String accountPassword; // Password of account
    private AccountStatus accountStatus; // Status of account (actived, pending, removed)
    private String accountName; // Full name associated with the account
    private String accountPhone; // Phone number associated with the account
    private String accountAddress; // Address associated with the account
    private String accountDOB; // Birthday of staff or user
    private String accountStartDay; // Day create account
    private String roleDescription; // Description of role the account holds

    /**
     *
     * Constructor default
     */
    public Account() {
    }

    public Account(String accountID, String accountName, String roleDescription) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.roleDescription = roleDescription;
    }

    /**
     * Constructor with all parameter
     * 
     * @param accountID ID of the account
     * @param accountEmail Email address of the account
     * @param accountPassword Password of the account
     * @param accountStatus Status of the account
     * @param roleDescription Description of the role of the account
     * @param accountName Full name associated with the account
     * @param accountPhone Phone number associated with the account
     * @param accountAddress Address associated with the account
     * @param roleID ID of the role associated with the account
     * @param accountDOB Birthday of staff or user
     * @param accountStartDay Day create account
     */
    public Account(String accountID, String accountEmail, String accountPassword, AccountStatus accountStatus, String accountName, String accountPhone, String accountAddress, String accountDOB, String accountStartDay, String roleDescription) {
        this.accountID = accountID;
        this.accountEmail = accountEmail;
        this.accountPassword = accountPassword;
        this.accountStatus = accountStatus;
        this.accountName = accountName;
        this.accountPhone = accountPhone;
        this.accountAddress = accountAddress;
        this.accountDOB = accountDOB;
        this.accountStartDay = accountStartDay;
        this.roleDescription = roleDescription;
    }

    /**
     * Get Birthday of staff or user
     * @return Birthday of staff or user
     */
    public String getAccountDOB() {
        return accountDOB;
    }

    /**
     * Set Birthday of staff or user
     * @param accountDOB Birthday of staff or user
     */
    public void setAccountDOB(String accountDOB) {
        this.accountDOB = accountDOB;
    }

    /**
     * Get Day create account
     * @return Day create account
     */
    public String getAccountStartDay() {
        return accountStartDay;
    }

    /**
     * Set Day create account
     * @param accountStartDay Day create account
     */
    public void setAccountStartDay(String accountStartDay) {
        this.accountStartDay = accountStartDay;
    }
    
    /**
     *
     * Get ID of the account
     *
     * @return String ID of the account
     */
    public String getAccountID() {
        return accountID;
    }

    /**
     *
     * Set ID of the account
     *
     * @param accountID ID of the account
     */
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    /**
     *
     * Get email address of the account
     *
     * @return String email address of the account
     */
    public String getAccountEmail() {
        return accountEmail;
    }

    /**
     *
     * Set email address of the account
     *
     * @param accountEmail email address of the account
     */
    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    /**
     *
     * Get password of the account
     *
     * @return String password of the account
     */
    public String getAccountPassword() {
        return accountPassword;
    }

    /**
     *
     * Set password of the account
     *
     * @param accountPassword password of the account
     */
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    /**
     *
     * Get status of the account
     *
     * @return AccountStatus status of the account
     */
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    /**
     *
     * Set status of the account
     *
     * @param accountStatus status of the account
     */
    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     *
     * Get description of the role of the account
     *
     * @return int description of the role of the account
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     *
     * Set description of the role of the account
     *
     * @param roleDescription description of the role of the account
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /**
     * Get full name associated with the account
     *
     * @return accountName full name associated with the account
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Set full name associated with the account
     *
     * @param accountName full name associated with the account
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Get phone number associated with the account
     *
     * @return accountPhone phone number associated with the account
     */
    public String getAccountPhone() {
        return accountPhone;
    }

    /**
     * Set phone number associated with the account
     *
     * @param accountPhone phone number associated with the account
     */
    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    /**
     * Get address associated with the account
     *
     * @return accountAddress address associated with the account
     */
    public String getAccountAddress() {
        return accountAddress;
    }

    /**
     * Set address associated with the account
     *
     * @param accountAddress address associated with the account
     */
    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }


}
