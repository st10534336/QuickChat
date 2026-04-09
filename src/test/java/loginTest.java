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
        assertEquals(expected, actual, "checkUsername() method failed");
    }
}
