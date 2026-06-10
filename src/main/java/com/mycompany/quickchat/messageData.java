/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author User
 */
public class messageData {
    //public int numberOfSentMessages;
    public String messageHash;
    public String messageID;
    public String senderNumber;
    public String recipientNumber;
    public String message;
    
    public messageData (String rawMessageString, String recipientNumber, String senderNumber, String messageID, String messageHash) {
        this.message = rawMessageString;
        this.senderNumber = senderNumber;
        this.recipientNumber = recipientNumber;
        this.messageID = messageID;
        this.messageHash = messageHash;
    }
    
}
