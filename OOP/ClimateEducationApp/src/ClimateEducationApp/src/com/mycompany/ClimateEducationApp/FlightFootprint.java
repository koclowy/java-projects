/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ClimateEducationApp;
/**
 *
 * @author chloe
 */
public class FlightFootprint {
    // Variables for flights
    double flightduration;
    int numberOfFlights;
    int flightfootprint;
    
    // Constructor method
    public FlightFootprint (double flightduration, int numberOfFlights, int flightfootprint){
        this.flightduration = flightduration;
        this.numberOfFlights = numberOfFlights;
        this.flightfootprint = flightfootprint;
    }
    
    // Calculates flight footprint
    public double calculatefootprint() {
        if (flightduration <= 4) {
            flightfootprint = numberOfFlights * 1100;
        } else if (flightduration > 4) {
            flightfootprint = numberOfFlights * 4400;
        } else {
            System.out.println("Error.");
        }
        return flightfootprint;
    }
}



