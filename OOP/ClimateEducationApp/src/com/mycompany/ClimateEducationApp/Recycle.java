/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ClimateEducationApp;
/**
 *
 * @author chloe
 */
public class Recycle {
    // Declares variables for recycling footprint
    String recycleNewspaper;
    double totalNewspaperFootprint;
    String recycleAluminium; 
    double totalAluminiumFootprint;

    // Constructor 
    public Recycle(String recycleNewspaper, String recycleAluminium) {
        this.recycleNewspaper = recycleNewspaper;
        this.recycleAluminium = recycleAluminium;
    }

    // Calculates newspaper footprint
    public double calculateNewspaper() {
        if (recycleNewspaper.equalsIgnoreCase("Yes")) {
        } else if (recycleNewspaper.equalsIgnoreCase("No")) {
            totalNewspaperFootprint = 184;
        } else {
            System.out.println("Please enter a valid answer");
        }
        return totalNewspaperFootprint;
    }

    // Calculates aluminium footprint
    public double calculateAluminium() {
        if (recycleAluminium.equalsIgnoreCase("Yes")) {
            
        } else if (recycleAluminium.equalsIgnoreCase("No")) {
            totalAluminiumFootprint = 166;            
        } else {
            System.out.println("Please enter a valid answer");
        }
        return totalAluminiumFootprint;
    }
}

