/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ClimateEducationApp;

/**
 *
 * @author chloe
 */
public class CarbonFootprint {
    public double mileage;
    
    // Initializes mileage value
    public CarbonFootprint (double mileage){
        this.mileage = mileage;
    }
    
    // Calculates Car footprint
    public double calculateCarFootprint() {
        return (mileage * 0.79);
    }
}


