package com.pluralsight;

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
        // loop over inventory and return a list of vehicles that match the price range

        // start a new list for filter cars

        // loop over inventory and add matching cards to filter list

        // return the list
        return null;


    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        // loop over inventory and return a list of vehicles that match the price range

        // start a new list for filter cars

        // loop over inventory and add matching cards to filter list

        // return the list
        return null;


    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        // loop over inventory and return a list of vehicles that match the price range

        // start a new list for filter cars

        // loop over inventory and add matching cards to filter list

        // return the list
        return null;

    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        // loop over inventory and return a list of vehicles that match the price range

        // start a new list for filter cars

        // loop over inventory and add matching cards to filter list

        // return the list
        return null;
    }
    public ArrayList<Vehicle> getVehiclesbyType(String type) {
        // loop over inventory and return a list of vehicles that match the price range

        // start a new list for filter cars

        // loop over inventory and add matching cards to filter list

        // return the list
        return null;
    }


}


