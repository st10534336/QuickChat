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
    public void testCheckUsernameCorrect() {
        Login login = new Login();
        String firstName = "Jeff";
        String lastName = "Bezos";
        String username = "kyl_1";
        
        boolean expected = true;
        boolean actual = login.checkUsername(username);
        assertEquals(expected, actual, "Welcome " + firstName + " " + lastName + " it is great to see you.");
        
    
    }
    
    @Test
    public void testCheckUsernameIncorrect() {
        Login login = new Login();
        String wrongUsername = "kyle!!!!!!!";
        boolean expected2 = false;
        boolean actual2 = login.checkUsername(wrongUsername);
        assertEquals(expected2, actual2, login.USERNAME_REQUIREMENT_MESSAGE);
    }
    
    @Test
    public void testCheckPasswordComplexityOfCorrectPassword() {
        Login login = new Login();
        String password = "Ch&&sec@ke99!";
        boolean expected = true;
        boolean actual = login.checkPasswordComplexity(password);
        assertEquals(expected, actual, login.PASSWORD_REQUIREMENT_MESSAGE);
    }
    
    @Test
    public void testCheckPasswordComplexityOfInCorrectPassword() {
        Login login = new Login();
        String password = "password";
        boolean expected = false;
        boolean actual = login.checkPasswordComplexity(password);
        assertEquals(expected, actual, login.PASSWORD_REQUIREMENT_MESSAGE);
    }
    
    //This is checkUserCellphoneNumber() being tested on a correct number
    @Test
    public void testCheckUserCellphoneNumberOnCorrectNumber() {
        Login login = new Login();
        String phoneNumber = "+27838968976";
        boolean expected = true;
        boolean actual = login.checkCellphoneNumber(phoneNumber);
        assertEquals(expected, actual, login.INCORRECTLY_FORMATTED_CELLPHONE_NUMBER);
    }
    
    //This is checkUserCellphoneNumber() being tested on an incorrect number
    @Test
    public void testCheckUserCellphoneNumberOnInCorrectNumber() {
        Login login = new Login();
        String phoneNumber = "08966553";
        boolean expected = false;
        boolean actual = login.checkCellphoneNumber(phoneNumber);
        assertEquals(expected, actual, login.INCORRECTLY_FORMATTED_CELLPHONE_NUMBER);
    }
    
    @Test
    public void testRegisterUser() {
        Login login = new Login();
        String Username = "U_ser";
        String Password = "@Timmy123";
        String expected = Username + " has been successfully registered";
        String actual = login.registerUser(Username, Password);
        assertEquals(expected, actual, "testRegisterUser() function failed");
        
        String Username2 = "Panna_22";
        String Password2 = "Pan22";
        String expected2 = login.INCORRECLY_FORMATTED_USERNAME_MESSAGE;
        String actual2 = login.registerUser(Username2, Password2);
        assertEquals(expected2, actual2, "testRegisterUser() function failed");
         
    }
    
    //testing the loginUser() function, it should return true for the test to pass
    @Test
    public void LoginSuccessful() {
        Login login = new Login();
        String username = "U_ser";
        String password = "@Timmy123";
        String registeredUsername = username;
        String registeredPassword = password;
        boolean actual = login.loginUser(username, password, registeredUsername, registeredPassword);
        assertTrue(actual, login.FAILED_LOGIN_MESSAGE);
    }
    
    //testing the loginUser() function, it should return false for the test to pass
    @Test
    public void LoginFailed() {
        Login login = new Login();
        String username = "User_";
        String password = "@Timmy12W";
        String registeredUsername = "user_";
        String registeredPassword = "Timmy123@";
        boolean actual = login.loginUser(username, password, registeredUsername, registeredPassword);
        assertFalse(actual, login.FAILED_LOGIN_MESSAGE);
    }
    
    @Test
    public void usernameCorrectlyFormatted() {
        Login login = new Login();
        String Username = "kyl_1";
        boolean actual = login.checkUsername(Username);
        assertTrue(actual, login.INCORRECLY_FORMATTED_USERNAME_MESSAGE);

    }
    
    @Test
    public void usernameIncorrectlyFormatted() {
        Login login = new Login();
        String Username = "kyle!!!!!!!";
        boolean actual = login.checkUsername(Username);
        assertFalse(actual, login.INCORRECLY_FORMATTED_USERNAME_MESSAGE);
    }
    
    @Test
    public void PasswordcorrectlyFormatted() {
        Login login = new Login();
        String password = "@Lincoln123";
        boolean actual = login.checkPasswordComplexity(password);
        assertTrue(actual, login.INCORRECLY_FORMATTED_PASSWORD_MESSAGE);
    }
    
    @Test
    public void PasswordIncorrectlyFormatted() {
        Login login = new Login();
        String password = "password";
        boolean actual = login.checkPasswordComplexity(password);
        assertFalse(actual, login.INCORRECLY_FORMATTED_PASSWORD_MESSAGE);
    }
    
    @Test
    public void correctCellphoneNumber() {
        Login login = new Login();
        String number = "+27838968976";
        boolean actual = login.checkCellphoneNumber(number);
        assertTrue(actual, login.INCORRECTLY_FORMATTED_CELLPHONE_NUMBER);
    }
    
    @Test
    public void incorrectCellphoneNumber() {
        Login login = new Login();
        String number = "08966553";
        boolean actual = login.checkCellphoneNumber(number);
        assertFalse(actual, login.INCORRECTLY_FORMATTED_CELLPHONE_NUMBER);
    }
}
