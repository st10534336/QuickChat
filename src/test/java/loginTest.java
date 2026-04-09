/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.quickchat.Login;
/**
 *
 * @author User
 */
public class loginTest {
    
    @Test
    public void testCheckUsername() {
        Login login = new Login();
        String username = "user_name";
        boolean expected = false;
        boolean actual = login.checkUsername(username);
        assertEquals(expected, actual, "checkUsername() method failed testing!");
    }
    
    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login();
        String password = "@Password12";
        boolean expected = true;
        boolean actual = login.checkPasswordComplexity(password);
        assertEquals(expected, actual, "checkPasswordComplexity() method failed testing!");
    }
    
    @Test
    public void testCheckUserCellphoneNumber() {
        Login login = new Login();
        String phoneNumber = "+27785698756";
        boolean expected = true;
        boolean actual = login.checkCellphoneNumber(phoneNumber);
        assertEquals(expected, actual, "checkCellphoneNumber() method failed testing!");
    }
}
