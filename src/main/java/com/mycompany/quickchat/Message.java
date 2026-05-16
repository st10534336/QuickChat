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
    
    
}

public class Message {
    private String messagesSent [];
    
    public String generateMessageID() {
        Random randomizer = new Random();
        String randomID = "";
        while (randomID.length() != 10) {
            String number = Integer.toString(randomizer.nextInt(0, 9));
            randomID += number;
        }
        return randomID;
    }
    
    public boolean checkMessageID(String messageID) {
        return messageID.length() == 10;
    }
    
    public String checkRecientCell(String phonenumber) {
        Login login = new Login();
        boolean cellTest = login.checkCellphoneNumber(phonenumber);
        
        if (cellTest) {
            return "Cellphone number successfully captured";
        }
        return """
               Cellphone number is incorrectly formatted or does not contain an international code.
                \n Please correct the number and try again.""";
        
    }
    
    public String createMessageHash(String message) {
        
        return "";
    }
    
    public String sentMessage() {
        return "";
    }
    
    public String printMessages() {
        return "";
    }
    
    public int returnTotalMessages(){
        return 1;
    }
    
    //The POE said this function should use JSONs to store messages
    public void storeMessage() {
    }
    
}
