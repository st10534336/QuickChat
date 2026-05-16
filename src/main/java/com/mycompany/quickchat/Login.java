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
    
    public final String INCORRECLY_FORMATTED_USERNAME_MESSAGE = "Username is incorrectly formatted";
    public final String INCORRECLY_FORMATTED_PASSWORD_MESSAGE = "Password does not meet complexity requirements";
    
    public final String INCORRECTLY_FORMATTED_CELLPHONE_NUMBER = "Cellphone number incorrectly formatted or does not contain international code";
    
    public final String PASSWORD_REQUIREMENT_MESSAGE = "incorrectly formatted password, please re-enter password \n it must have a minimum of 8 charaters, 1 special character, 1 Capital letter and it must contain a number";
    public final String USERNAME_REQUIREMENT_MESSAGE = "username is not correctly formatted \nplease ensure that your username contains and underscore and is no longer than five characters in length.";
    
    public final String USERNAME_SUCCESSFUL_CAPTURE_MESSAGE = "Username has successfully been captured";
    public final String PASSWORD_SUCCESSFUL_CAPTURE_MESSAGE = "Password has successfully been captured";
    public final String CELLPHONE_NUMBER_SUCCESSFUL_CAPTURE_MESSAGE = "Cellphone number successfully captured";
    
    public final String SUCCESSFULL_LOGIN_MESSAGE = "login was successful :D";
    public final String FAILED_LOGIN_MESSAGE = "login was unsuccessful :(";
    public final String LOGIN_RETRY_MESSAGE = "Username or password incorrect, please try again";
    
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
                
                //old debug code
                //System.out.println(password.charAt(i));
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
        
 
        String returnMessage;
        
        if (usernameCorrectlyFormatted && passwordMeetsComplexityRequirements) {
            returnMessage = Username + " has been successfully registered";
            return returnMessage;
        }
        else {
            if (!usernameCorrectlyFormatted) {
            returnMessage = this.INCORRECLY_FORMATTED_USERNAME_MESSAGE;
            return returnMessage;
            }
            if (!passwordMeetsComplexityRequirements) {
                returnMessage = this.INCORRECLY_FORMATTED_PASSWORD_MESSAGE;
            return returnMessage;
            }
        }
        return "";
                
    }
    
    public boolean loginUser(String enteredUsername, String enteredPassword, String registeredUsername, String registeredPassword){    
        boolean usernamesAreMatching = enteredUsername.equals(registeredUsername);
        boolean passwordsAreMatching = enteredPassword.equals(registeredPassword);
        
        //old debugging code
        //System.out.println("Passwords are matching: " + passwordsAreMatching + ", " + enteredPassword + ", " + registeredPassword);
        //System.out.println("Usernames are mathing: " + usernamesAreMatching + ", " + enteredUsername + ", " + registeredUsername);
        
        return (usernamesAreMatching && passwordsAreMatching);
    }
    
    public String returnLoginStatus (boolean loginUserResult) {
        
        //old debugging code    
        //System.out.println("");
        //System.out.println("loginUserResult " + loginUserResult);
        
        if (loginUserResult) {
            return this.SUCCESSFULL_LOGIN_MESSAGE;
        }
        return this.FAILED_LOGIN_MESSAGE;
    }
    
}
