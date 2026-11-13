package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;



    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        // creates an empty list ready to hold vehicles
        this.inventory = new ArrayList<>();
    }

    // getter
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // add vehicle to the inventory
    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    // get all the vehicles
    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void removeVehicle(Vehicle vehicle) {
        // take the vehicle passed in out of the inventory list
    }

    // get all the vehicles
    public ArrayList<Vehicle> getVehiclesByPrice(int min, int max) {

        // start a new list for filter cars
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        // looking at every vehicle in the inventory
        for (Vehicle vehicle : inventory) {
            // check whether the vehicles price is within the range
            if(vehicle.getPrice().compareTo(new BigDecimal(min)) >= 0 &&
            vehicle.getPrice().compareTo(new BigDecimal(max)) <=0) {

                // add the matching vehicle to new list
                filteredVehicles.add(vehicle);
            }
        }

        // return the list
        return filteredVehicles;


    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {

        // create an empty list for matching vehicles
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        // Look at every vehicle in the inventory
        for (Vehicle vehicle : inventory) {
            // check whether both make and model match
            if (vehicle.getMake().equalsIgnoreCase(make) &&
                    vehicle.getModel().equalsIgnoreCase(model)) {

                // add matching vehicle to the list
                filteredVehicles.add(vehicle);
            }
        }
        // return the matching vehicles
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        // create an empty array list for matching vehicles
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        // loop through every vehicle
        for (Vehicle vehicle : inventory) {

            // check if the vehicles year is within the range
            if(vehicle.getYear() >= min && vehicle.getYear() <= max) {

                // add matching vehicle to the list
                filteredVehicles.add(vehicle);
            }
        }
        // return to matching vehicles
        return filteredVehicles;

    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        // create an empty list for matching vehicles
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        // loop through each vehicle in inventory
        for (Vehicle vehicle : inventory) {

            // check if the mileage is withing the range
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {

                // add matching vehicle to the list
                filteredVehicles.add(vehicle);
            }
        }
        // return to filtered vehicles
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesbyType(String type) {
        // create an array list for matching vehicles
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        // loop through every vehicle in inventory
        for (Vehicle vehicle : inventory) {

            // check if the vehicle type matches
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {

                //add matching vehicle to list
                filteredVehicles.add(vehicle);
            }
        }
        // return the matching vehicles
        return filteredVehicles;
    }


}


