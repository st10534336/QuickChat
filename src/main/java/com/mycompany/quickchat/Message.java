/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;
import java.util.Random;
import com.mycompany.quickchat.Login;
/**
 *
 * @author Student
 */

class messageData {
    //public int numberOfSentMessages;
    public String messageHash;
    public String messageID;
    public String recipientNumber;
    public String message;
    
    public messageData (String rawMessageString, String recipientNumber, String messageID, String messageHash) {
        this.message = rawMessageString;
        this.recipientNumber = recipientNumber;
        this.messageID = messageID;
        this.messageHash = messageHash;
    }
    
}

public class Message {
    private messageData[] messagesSent;
    private int numMessagesSent=0;
    
    public int MESSAGE_ID_LENGTH = 10;
    
    public String generateMessageID() {
        Random randomizer = new Random();
        String randomID = "";
        while (randomID.length() != MESSAGE_ID_LENGTH) {
            String number = Integer.toString(randomizer.nextInt(0, 9));
            randomID += number;
        }
        return randomID;
    }
    
    public boolean checkMessageID(String messageID) {
        return messageID.length() == 10;
    }
    
    public String checkRecipientCell(String phonenumber) {
        Login login = new Login();
        boolean cellTest = login.checkCellphoneNumber(phonenumber);
        
        if (cellTest) {
            return "Cellphone number successfully captured";
        }
        return """
               Cellphone number is incorrectly formatted or does not contain an international code.
                \n Please correct the number and try again.""";
        
    }
    
    public String createMessageHash(String rawMessageString, String messageID) {
        String first2Numbers = rawMessageString.substring(0, 2);
        String messageNumber = Integer.toString(this.messagesSent.length + 1);
        String[] words = rawMessageString.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String messageHash = first2Numbers + ":" + messageNumber + ":" + firstWord + lastWord;
        return messageHash;
    }
    
    public messageData genenrateMessageData(String rawMessageString, String recipientNumber) {
        String newMessageID = generateMessageID();
        String newMessageHash = createMessageHash(rawMessageString, newMessageID);
        
        messageData newMessageData = new messageData(rawMessageString, recipientNumber, newMessageID, newMessageHash);
        return newMessageData;
    }
    
    public String sentMessage(int userInput) {
        switch (userInput) {
            case 1:
                return "Message Successfully Sent";
            case 2:
                return "Press 0 to delete message";
            case 3:
                return "Message Successfully Stored";
            default:
                return "Invalid Selection";
        }
    }
    
    public String[] printMessages() {
        String[] messages = {};
        for (int i = 0; i<messagesSent.length; i++){
            messages[i] = messagesSent[i].message;
        }
        return messages;
    }
    
    public int returnTotalMessages(){
        return numMessagesSent;
    }
    
    //The POE said this function should use JSONs to store messages
    public void storeMessage() {
    }
    
}
