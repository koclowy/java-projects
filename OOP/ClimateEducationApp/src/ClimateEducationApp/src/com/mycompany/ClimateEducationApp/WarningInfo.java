/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ClimateEducationApp;

/**
 *
 * @author User
 */
public class WarningInfo {
    // WarningInfo class constructor
    public class Location {
        private String locationName;

        // Location class constructor
        public Location(String locationName) {
            this.locationName = locationName;
        }

        // Location getters and setters
        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
        }
    
        // Declaring Danger class
        public class Danger {
            private String danger;

            // Danger class constructor
            public Danger(String danger) {
                this.danger = danger;
            }

            // Danger getters and setters
            public String getDanger() {
                return danger;
            }

            public void setDescription(String description) {
                this.danger = description;
            }
            
            // Declaring PreventiveMeasures class
            public class PreventiveMeasures {
                private String preventiveMeasures;

                // PreventiveMeasures class constructor
                public PreventiveMeasures(String preventiveMeasures) {
                    this.preventiveMeasures = preventiveMeasures;
                }

                // PreventiveMeasures getters and setters
                public String getMeasure() {
                    return preventiveMeasures;
                }

                public void setMeasure(String preventiveMeasures) {
                    this.preventiveMeasures = preventiveMeasures;
                }
            }
        }
    }
}
