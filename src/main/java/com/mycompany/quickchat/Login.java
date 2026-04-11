/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Login {
    
    String incorrectlyFormattedUsernameMessage = "Username is incorrectly formatted";
    String incorrectlyFormattedPasswordMessage = "Password does not meet complexity requirements";
    String incorrectlyFormattedNumber = "Number was incorrectly formatted";
    String passwordRequirementMessage = "incorrectly formatted password, please re-enter password \n it must have a minimum of 8 charaters, 1 special character, 1 Capital letter and it must contain a number";
    String usernameRequirementMessage = "incorrectly formatted username, the username must be no longer than 5 character and must contain a underscore";
    String successfulLoginMessage = "login was successful";
    String failedLoginMessage = "the login was unsuccessful :(";
    
    public boolean checkUsername(String userName) {
        return (userName.contains("_") && userName.length() <= 5);
    }
    
    public boolean checkPasswordComplexity(String password) {
        boolean isMinLength = (password.length() >= 8);
        
        boolean containsCapitalLetter = false;
        String uppercasePassword = password.toUpperCase();
        
        boolean containsANumber = false;
        boolean containsSpecialCharacter = false;
        
        for (int i=0; i<password.length(); i++){
            //check if the current character is a capital letter
            if ((password.charAt(i) == uppercasePassword.charAt(i)) && Character.isLetter(password.charAt(i))) {
                containsCapitalLetter = true;
                System.out.println(password.charAt(i));
            }
            
            //check if the current character is a digit
            if (Character.isDigit(password.charAt(i))) {
                containsANumber = true;
            }
            
            //check if the current character is a special character
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                containsSpecialCharacter = true;
            }
            
            
        }
        
        
        return (isMinLength && containsCapitalLetter && containsANumber && containsSpecialCharacter);
    }
    
    public boolean checkCellphoneNumber(String phonenumber) {
        boolean startWithCountryCode = phonenumber.startsWith("+27");
        boolean isTwelveDigitsLong = (phonenumber.length() == 12);
        
        return (startWithCountryCode && isTwelveDigitsLong);
    }
    
    public String registerUser(String Username, String Password) {
        boolean usernameCorrectlyFormatted = checkUsername(Username);
        boolean passwordMeetsComplexityRequirements = checkPasswordComplexity(Password);
        
 
        String returnMessage = "";
        
        if (usernameCorrectlyFormatted && passwordMeetsComplexityRequirements) {
            returnMessage = Username + " has been successfully registered";
            return returnMessage;
        }
        else {
            if (!usernameCorrectlyFormatted) {
            returnMessage = this.incorrectlyFormattedUsernameMessage;
            return returnMessage;
            }
            if (!passwordMeetsComplexityRequirements) {
                returnMessage = this.incorrectlyFormattedPasswordMessage;
            return returnMessage;
            }
        }
        return "";
                
    }
    
    public boolean loginUser(String enteredUsername, String enteredPassword, String registeredUsername, String registeredPassword){    
        boolean usernamesAreMatching = enteredUsername.equals(registeredUsername);
        boolean passwordsAreMatching = enteredPassword.equals(registeredPassword);
        
        //System.out.println("Passwords are matching: " + passwordsAreMatching + ", " + enteredPassword + ", " + registeredPassword);
        //System.out.println("Usernames are mathing: " + usernamesAreMatching + ", " + enteredUsername + ", " + registeredUsername);
        
        return (usernamesAreMatching && passwordsAreMatching);
    }
    
    public String returnLoginStatus (boolean loginUserResult) {
        System.out.println("");
        System.out.println("loginUserResult " + loginUserResult);
        if (loginUserResult) {
            return "Login was Successful";
        }
        return "Login failed";
    }
    
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
            
            if (regStatus.equals(login.incorrectlyFormattedPasswordMessage)) {
                System.out.println(login.passwordRequirementMessage);
                System.out.println("please re-enter password: ");
                password = scanner.nextLine();
            }
            
            if (regStatus.equals(login.incorrectlyFormattedUsernameMessage)){
               System.out.println(login.usernameRequirementMessage);
                System.out.println("please re-enter username: ");
                username = scanner.nextLine();
            }
            
            regStatus = login.registerUser(username, password);
            regStatusSuccess = username + " has been successfully registered";
            System.out.println(regStatus);
        }
        
        
        System.out.println("");
        System.out.println("Please Enter cellphone number e.g +27837657898");
        cellphone = scanner.nextLine();
        boolean cellphoneCheck = login.checkCellphoneNumber(cellphone);
        while (!cellphoneCheck) {
            System.out.println(login.incorrectlyFormattedNumber);
            System.out.println("please re-enter phone number: ");
            cellphone = scanner.nextLine();
            cellphoneCheck = login.checkCellphoneNumber(cellphone);
        }
    }
}
