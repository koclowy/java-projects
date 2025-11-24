/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ClimateEducationApp;

/**
 *
 * @author User
 */
public class Admin {
    // Data fields(username and password)
    private String username;
    private String password;    

    // Class constructor
    public Admin(String username,String password) {
        this.username = username;
        this.password = password;        
    }

    // Username getter method
    public String getUsername() {
        return username;
    }

    // Password getter method
    public String getPassword() {
        return password;
    }    
}
