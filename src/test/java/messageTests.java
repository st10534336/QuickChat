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
    
    @Test 
    public void recipientNumberCorrectlyFormatted() {
        Message message = new Message();
        String correctlyFormattedNumber = "+27718693002";
        String expected = Message.CHECK_RECIPIENT_CELL_PASS_TEXT;
        String actual = message.checkRecipientCell(correctlyFormattedNumber);
        assertEquals(expected, actual);
    }
    
    @Test 
    public void recipientNumberIncorrectlyFormatted() {
        Message message = new Message();
        String incorrectlyFormattedNumber = "08575975889";
        String expected = Message.CHECK_RECIPIENT_CELL_FAIL_TEXT;
        String actual = message.checkRecipientCell(incorrectlyFormattedNumber);
        assertEquals(expected, actual);
    }
    
    @Test
    public void messageIDTest() {
        Message message = new Message();
        String expected = "Message ID generated" + message.generateMessageID();
        assertEquals(expected, expected);
    
    }
    
    @Test
    public void sentMessageTest() {
        Message message = new Message();
        String userSelectOptionOneExpected = Message.USER_SELECTED_SEND_MESSAGE_TEXT;
        String userSelectOptionOneActual = message.sentMessage(1);
        
        String userSelectOptionTwoExpected = Message.USER_SELECTED_DISREGARD_MESSAGE_TEXT;
        String userSelectOptionTwoActual = message.sentMessage(2);
        
        String userSelectOptionThreeExpected = Message.USER_SELECTED_STORE_MESSAGE_TEXT;
        String userSelectOptionThreeActual = message.sentMessage(3);
    
        assertEquals(userSelectOptionOneExpected, userSelectOptionOneActual);
        assertEquals(userSelectOptionTwoExpected, userSelectOptionTwoActual);
        assertEquals(userSelectOptionThreeExpected, userSelectOptionThreeActual);

    }
    
    
}
