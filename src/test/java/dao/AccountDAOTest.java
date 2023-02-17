package dao;

import model.Account;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class AccountDAOTest {
    
    AccountDAO adao;                                               // create accountDAO to call function.
    public static final String emailExist = "user1@gmail.com";     // constant email is exist to test.
    public static final String passExist = "User12345@";           // constant password is exist to test.
    public static final String emailNotExist = "abc123@gmail.com"; // constant email is not exist to test.
    
    /**
     * Constructor.
     */
    public AccountDAOTest() {
        adao = new AccountDAO();
    }

    /**
     * Test login function is success case.
     */
    @Test
    public void testLoginAccountSuccessfully() {
        Account acc = adao.loginAccount(emailExist, passExist);
        assertNotNull("Login successfully!", acc);
    }
    
    /**
     * Test login function is failed case.
     */
    @Test
    public void testLoginAccountFailed() {
        Account acc = adao.loginAccount(emailNotExist, passExist);
         assertNull("Login failed!", acc);
    }

    /**
     * Test check account is exist function is in exist case.
     */
    @Test
    public void testCheckAccountIsExist() {
        Boolean status = adao.checkAccountIsExist(emailExist);
        assertTrue("Account is exist!", status);
    }
    
    /**
     * Test check account is exist function is in no exist case.
     */
    @Test
    public void testCheckAccountIsNotExist() {
        Boolean status = adao.checkAccountIsExist(emailNotExist);
        assertFalse("Account is not exist!", status);
    }

    /**
     * Test register account. 
     */
    @Test
    public void testRegisterAccount() {
        // nothing to test fucntion.
    }

    /**
     * Test update password. 
     */
    @Test
    public void testUpdatePassword() {
        // nothing to test fucntion.
    }
}
