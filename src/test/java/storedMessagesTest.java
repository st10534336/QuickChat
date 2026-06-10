/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.quickchat.Message;
import com.mycompany.quickchat.Message;
import com.mycompany.quickchat.messageData;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
/**
 *
 * @author User
 */

// !!!! DELETE storedMessageTestJSON.json before this JUNIT Test is RUN !!!!!!
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 1. Keeps variables alive across tests
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class storedMessagesTest {
    
    Message message = new Message("storedMessageTestJSON.json");
    
    String[] messages = {"Did you get the cake?", "Where are you? You are late! I have asked you to be on time.",
                        "yohoooo, I am at your gate.", "it is dinner time !", "Ok I am leaving without you."};
    String[] recipients = {"+27834557896","+27838884567", "+27834484567", "+27838884567", "+27838884567"};
    
    String sender = "+27785893285";
    messageData message1 = message.generateMessageData(messages[0], sender, recipients[0]);
    messageData message2 = message.generateMessageData(messages[1], sender, recipients[1]);
    messageData message3 = message.generateMessageData(messages[2], sender, recipients[2]);
    messageData message4 = message.generateMessageData(messages[3], sender, recipients[3]);
    messageData message5 = message.generateMessageData(messages[4], sender, recipients[4]);
 
    
    @Test
    @Order(1)
    public void populateArrays() {
        message.sendMessage(message1);
        message.storeMessage(message2);
        message.discardMessage(message3);
        message.sendMessage(message4);
        message.storeMessage(message5);
        System.out.println(message.getSentMessages().length);
        assertEquals(true, true);
    }
    
    
    @Test
    @Order(2)
    public void checkSentMessagesCorrectlyPopulated() {
        System.out.println("inside second test, messagesSent is equals to: "+message.messagesSent.size());
        String[] expected = {message1.message, message4.message};
        String[] actual = message.getSentMessages();
        assertArrayEquals(expected, actual);
    }
    
    @Test
    @Order(3)
    public void checkDisplayLongestString() {
        String expected = messages[1];
        String actual = message.showLongestStoredMessage();
        assertEquals(expected, actual);
    }
    
    @Test
    @Order(4)
    public void checkSearchMessageID() {
        String testData = message4.messageID;
        String expected = message4.message;
        String actual = message.showRecipientandMessageViaMessageID(testData);
        assertEquals(expected, actual);
    }
    
    @Test
    @Order(5)
    public void searchMessagesStoredForRecipient() {
        String testData = "+27838884567";
        String[] expected = {messages[1], messages[4]};
        String[] actual = message.showMessagesStoredForParticularRecipient(testData);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    @Order(6)
    public void deleteMessageViaHash() {
        String testData = message2.messageHash;
        String expected = message2.message;
        String actual = message.deleteMessageWithHash(testData);
        assertEquals(expected, actual);
    }
}
