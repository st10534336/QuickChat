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
}
