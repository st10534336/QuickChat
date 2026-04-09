/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author User
 */
public class Login {
    
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
}
