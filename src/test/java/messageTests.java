/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.quickchat.Message;
/**
 *
 * @author User
 */
public class messageTests {
    
    @Test
    public void messageLengthFail() {
        Message message = new Message();
        String messageText = """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
            Excepteur sint occaecat cupiditate non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.  
                         """;
        String expected = "Message exceeds 250 characters by " + Integer.toString(messageText.length() - Message.MAX_MESSAGE_CHARACTERS_LENGTH);
        String actual = message.messageLengthStatus(messageText);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void messageLengthPass() {
        Message message = new Message();
        String messageText2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua";
        String expected = Message.MESSAGE_LENGTH_STATUS_PASS_TEXT;
        String actual = message.messageLengthStatus(messageText2);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
    
}
