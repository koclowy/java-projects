/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ClimateEducationApp;

//import java.sql.*;

/**
 *
 * @author User
 */
public class User {
    // Declaring User class variables
    private String username;
    private String email;
    private String password;

    // Intializing variables
    public User(String username,  String email,String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // username getter method
    public String getUsername() {
        return username;
    }

    // password getter method
    public String getPassword() {
        return password;
    }
    
    // email getter method
    public String getEmail() {
        return email;
    }
}
