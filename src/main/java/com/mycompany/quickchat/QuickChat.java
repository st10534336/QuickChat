/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;
import com.mycompany.quickchat.Login;
import com.mycompany.quickchat.Message;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class QuickChat {

    public static void main(String[] args) {
        String firstName, lastName, username, password, cellphone;
        Login login = new Login();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("REGISTRATION WINDOW");
        
        System.out.println("Hello, Welcome to QuickChat");
        
        System.out.println("Please enter your first name: ");
        firstName = scanner.nextLine();
                
        System.out.println("please enter your last name: ");
        lastName = scanner.nextLine();
        
        System.out.println("Please enter your Username: ");
        username = scanner.nextLine();
        
        System.out.println("please enter your Password: ");
        password = scanner.nextLine();
        
        String regStatus = login.registerUser(username, password);
        String regStatusSuccess = username + " has been successfully registered";
        
        while (!regStatus.equals(regStatusSuccess)) {
            
            if (regStatus.equals(login.INCORRECLY_FORMATTED_PASSWORD_MESSAGE)) {
                System.out.println(login.PASSWORD_REQUIREMENT_MESSAGE);
                System.out.println("please re-enter password: ");
                password = scanner.nextLine();
            }
            
            if (regStatus.equals(login.INCORRECLY_FORMATTED_USERNAME_MESSAGE)){
                System.out.println(login.USERNAME_REQUIREMENT_MESSAGE);
                System.out.println("please re-enter username: ");
                username = scanner.nextLine();
            }
            
            regStatus = login.registerUser(username, password);
            regStatusSuccess = username + " has been successfully registered";
            System.out.println(regStatus);
        }
        
        System.out.println("");
        System.out.println(login.USERNAME_SUCCESSFUL_CAPTURE_MESSAGE);
        System.out.println(login.PASSWORD_SUCCESSFUL_CAPTURE_MESSAGE);
        System.out.println("");
        
        System.out.println("Please Enter cellphone number e.g +27837657898");
        cellphone = scanner.nextLine();
        
        boolean cellphoneCheck = login.checkCellphoneNumber(cellphone);
        while (!cellphoneCheck) {
            System.out.println(login.INCORRECTLY_FORMATTED_CELLPHONE_NUMBER);
            System.out.println("please re-enter phone number: ");
            cellphone = scanner.nextLine();
            cellphoneCheck = login.checkCellphoneNumber(cellphone);
        }
            
        System.out.println("");
        System.out.println(login.CELLPHONE_NUMBER_SUCCESSFUL_CAPTURE_MESSAGE);
        System.out.println("");
        
        System.out.println("---------------------------");
        System.out.println("LOGIN WINDOW");
        System.out.println("");
        
        System.out.println("Please enter your username");
        String usernameAttempt = scanner.nextLine();
        
        System.out.println("Please enter your password");
        String passwordAttempt = scanner.nextLine();
        
        boolean loginUser = login.loginUser(username, password, usernameAttempt, passwordAttempt);
        String loginStatus = login.returnLoginStatus(loginUser);
        
        System.out.println(loginStatus);
        
        while (!loginUser) {
            System.out.println("");
            System.out.println(login.LOGIN_RETRY_MESSAGE);
            System.out.println("");
            
            System.out.println("Please enter your username");
            usernameAttempt = scanner.nextLine();
        
            System.out.println("Please enter your password");
            passwordAttempt = scanner.nextLine();
            
            loginUser = login.loginUser(username, password, usernameAttempt, passwordAttempt);
            loginStatus = login.returnLoginStatus(loginUser);
            
        }
        
        //say that the login was successful and greet the user
        System.out.println(loginStatus);
        System.out.println("Welcome to QuickChat " + firstName + " " + lastName + "!, it's great to see you again!");
        
       
        String initialPrompt = """
                           
                           
        Enter the number for the action you want to perform:
        1. Send Messages
        2. Show Recently sent Messages (coming soon)
        3. Quit
                           
                           """;
        
        System.out.println(initialPrompt);
        
        Message message = new Message();
        int userInput = scanner.nextInt();
        
        while (userInput != 3) {
            
            if (userInput == 1) {
                
                System.out.println("please enter recipient number e.g +27789082345");
                scanner.nextLine();
                String recipientNumber = scanner.nextLine();
                
                while(!login.checkCellphoneNumber(recipientNumber)) {
                    System.out.println(message.checkRecipientCell(recipientNumber));
                    System.out.print("re-enter recipient cell: ");
                    recipientNumber = scanner.nextLine();
               }
                
                System.out.println("""
                Enter the number of messages you will send
                                   """);
                int numberOfMessages = scanner.nextInt();
                
                for (int messageCount=0; messageCount<Integer.min(Message.MAX_MESSAGE_STORAGE_CAPACITY, numberOfMessages); messageCount++) {
                    
                    scanner.nextLine();
                    System.out.println("");
                    System.out.println("Type message " + messageCount + ":");

                    String rawMessageText = scanner.nextLine();
                    String messageLengthStatus = message.messageLengthStatus(rawMessageText);
                    System.out.println(messageLengthStatus);
                    
                    while (rawMessageText.length() > Message.MAX_MESSAGE_CHARACTERS_LENGTH) {
                        System.out.println(messageLengthStatus);
                        System.out.println("retype message: ");
                        rawMessageText = scanner.nextLine();
                        messageLengthStatus = message.messageLengthStatus(rawMessageText);
                    }
                    
                    messageData mData = message.genenrateMessageData(rawMessageText, recipientNumber);

                    System.out.println("""

                    choose what should happen with this message:
                    1.send message
                    2.disregard message
                    3.Store message to send later
                                       """);

                    int userOption = scanner.nextInt();
                    String messageSentStatus = message.sentMessage(userOption);
                    
                    if (userOption == 1) {
                        message.saveMessage(mData);
                        message.displayMessageDetails(mData);
                    }
                    
                    System.out.println(messageSentStatus);
                    //System.out.println(mData.messageHash);
                    
                    
                }
  
                
                             
               
            }
            else if (userInput == 2) {
                System.out.println("Feature is still a work-in-progress");
            }
            else {
                System.out.println("Invalid Input");
            }
            System.out.println(initialPrompt);
            userInput = scanner.nextInt();
        }
        
        System.out.println("Thank you for using quickChat");
    
    
    }
}
