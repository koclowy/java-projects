/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ClimateEducationApp;
/**
 *
 * @author chloe
 */
public class HouseFootprint {
    // Declare variables for house footprint
    double electricBill;
    double gasBill;
    double oilBill;

    // Initializes variables
    public HouseFootprint(double electricBill, double gasBill, double oilBill) {
        this.electricBill = electricBill;
        this.gasBill = gasBill;
        this.oilBill = oilBill;
    }

    // Calculate carbon footprint produced by house
    public double calculateFootprint() {
        return (electricBill * 105) + (gasBill * 105) + (oilBill * 113);
    }

   
}



