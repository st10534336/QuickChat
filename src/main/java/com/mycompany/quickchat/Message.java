/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;
import java.util.Random;
import com.mycompany.quickchat.Login;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

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
    
    public static final String MESSAGE_LENGTH_STATUS_PASS_TEXT = """
                   Message is ready to send.""";
    
    public static final String CHECK_RECIPIENT_CELL_PASS_TEXT = "Cellphone number successfully captured";
    public static final String CHECK_RECIPIENT_CELL_FAIL_TEXT = """
                               Cellphone number is incorrectly formatted or does not contain an international code.
                               Please correct the number and try again.""";
    
    public static final String USER_SELECTED_SEND_MESSAGE_TEXT = "Message Successfully Sent";
    public static final String USER_SELECTED_DISREGARD_MESSAGE_TEXT = "Press 0 to delete message";
    public static final String USER_SELECTED_STORE_MESSAGE_TEXT = "Message Successfully Stored";
    
    public static final String MESSAGE_STORAGE_FILE_NAME = "savedMessages.json";
    
    public static final int MAX_MESSAGE_CHARACTERS_LENGTH = 250;
    public static final int MAX_MESSAGE_STORAGE_CAPACITY = 250;
    
    messageData[] messagesSent = new messageData[MAX_MESSAGE_STORAGE_CAPACITY];
    messageData[] discardedMessages = new messageData[MAX_MESSAGE_STORAGE_CAPACITY];   
    messageData[] storedMessages = new messageData[MAX_MESSAGE_STORAGE_CAPACITY];
    String[] messageHashes = new String[MAX_MESSAGE_STORAGE_CAPACITY];
    String[] messageIDs = new String[MAX_MESSAGE_STORAGE_CAPACITY];

    
    
    int numMessagesSent=0;
    final public int MESSAGE_ID_LENGTH = 10;
    
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
            return CHECK_RECIPIENT_CELL_PASS_TEXT;
        }
        return CHECK_RECIPIENT_CELL_FAIL_TEXT;
        
    }
    
    public String createMessageHash(String rawMessageString, String messageID) {
        String first2Numbers = messageID.substring(0, 2);
        String messageNumber = Integer.toString(this.numMessagesSent + 1);
        String[] words = rawMessageString.split(" ");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        String messageHash = first2Numbers + ":" + messageNumber + ":" + firstWord + lastWord;
        return messageHash;
    }
    
    public messageData genenrateMessageData(String rawMessageString, String recipientNumber) {
        String newMessageID = generateMessageID();
        String newMessageHash = createMessageHash(rawMessageString, newMessageID);
        
        messageData newMessageData = new messageData(rawMessageString, recipientNumber, newMessageID, newMessageHash);
        return newMessageData;
    }
    
    public String messageLengthStatus(String messageText) {
        if (messageText.length() <= MAX_MESSAGE_CHARACTERS_LENGTH) {
            return MESSAGE_LENGTH_STATUS_PASS_TEXT;
        }
        else {
            return "Message exceeds 250 characters by " + Integer.toString(messageText.length() - Message.MAX_MESSAGE_CHARACTERS_LENGTH);
        }
    }
    
    public String sentMessage(int userInput) {
        switch (userInput) {
            case 1:
                return USER_SELECTED_SEND_MESSAGE_TEXT;
            case 2:
                return USER_SELECTED_DISREGARD_MESSAGE_TEXT;
            case 3:
                return USER_SELECTED_STORE_MESSAGE_TEXT;
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
    
    public void displayMessageDetails(messageData mData) {
        System.out.println("");
        System.out.println("Message ID: " + mData.messageID);
        System.out.println("Message Hash: " + mData.messageHash);
        System.out.println("Message Recipient: " + mData.recipientNumber);
        System.out.println("Message: ");
        System.out.println(mData.message);
    }
    
    
    public void saveMessage(messageData mData) {
        messagesSent[numMessagesSent] = mData;
        numMessagesSent += 1;
    }
    public int returnTotalMessages(){
        return numMessagesSent;
    }
    
    public void saveStoredMessagesStateToJson () {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // 3. Serialize and write data directly to the file
        
        //writing to a file
        try (FileWriter writer = new FileWriter(MESSAGE_STORAGE_FILE_NAME)) {
            
            gson.toJson(storedMessages, writer);
            System.out.println("JSON successfully saved to " + MESSAGE_STORAGE_FILE_NAME);
            
        } catch (IOException e) {
            
            System.err.println("Error writing JSON file: " + e.getMessage());
            
        }
    }
    
    public void loadStoredMessagesStateFromJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try (FileReader reader = new FileReader(MESSAGE_STORAGE_FILE_NAME)) {
            
            storedMessages = gson.fromJson(reader, messageData[].class);
        }
        catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
    }
    
    
    public void deleteMessageWithHash(String messageHash) {
        messageData[] tempArray = new messageData[MAX_MESSAGE_STORAGE_CAPACITY];
        
        for (int i=0; i<storedMessages.length; i++) {
            if (!storedMessages[i].messageHash.equals(messageHash)) {
                tempArray[i] = storedMessages[i];
            } 
        }
        
        storedMessages = tempArray;
        
        saveStoredMessagesStateToJson();
    }
    
    
    public void discardMessage(messageData mData) {
        discardedMessages[discardedMessages.length] = mData;
    }
    
    
    
    //The POE said this function should use JSONs to store messages
    public void storeMessage(messageData mData) {
        storedMessages[storedMessages.length] = mData;
        saveStoredMessagesStateToJson();
    }
    
}
