package com.pluralsight;
import java.io.BufferedWriter;
import java.math.BigDecimal;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;


public class DealershipFileManager {

    // stores tge inventory filename
    private String csvFile = "inventory.csv";

    public Dealership getDealership() {

        // declare variable to hold the dealership
        Dealership dealership = null;


        // create a reader to Open and read the csv file
        try (BufferedReader inventoryReader = new BufferedReader(new FileReader(csvFile))) {

            // reading one line at a time
            String dealershipInfo = inventoryReader.readLine();

            // checks that the file is not empty

            if (dealershipInfo != null) {
                String[] dealershipData = dealershipInfo.split("\\|"); // separating the values of the file
                // checks for first line to have name, address and phone #
                if(dealershipData.length !=3) {
                    throw new IllegalArgumentException("Invalid dealership information");
                }

                // create a dealership object
                dealership = new Dealership(
                        dealershipData[0],
                        dealershipData[1],
                        dealershipData[2]
                );
                String vehicleInfo;
                // converting this line into a vehicle
                while ((vehicleInfo = inventoryReader.readLine()) != null) {

                    // splitting the vehicle information
                    String[] vehicleData = vehicleInfo.split("\\|");

                    // if statement checks each line has all 8 fields.
                    if(vehicleData.length != 8) {
                        continue; // if a line is missing info, continue, skips line and onto the next one.
                    }
                    // converting values into the correct data type
                    int vin = Integer.parseInt(vehicleData[0]);
                    int year = Integer.parseInt(vehicleData[1]);

                    String make = vehicleData[2];
                    String model = vehicleData[3];
                    String vehicleType = vehicleData[4];
                    String color = vehicleData[5];

                    int odometer = Integer.parseInt(vehicleData[6]);
                    BigDecimal price = new BigDecimal(vehicleData[7]);

                    // creating vehicle object
                    Vehicle vehicle = new Vehicle(vin,
                            year,
                            make,
                            model,
                            vehicleType,
                            color,
                            odometer,
                            price);
                    // add the vehicle to the dealership
                    dealership.addVehicle(vehicle);
                }


            }

        } catch (Exception e) {
            e.printStackTrace(); // show error message

        }


        // after we create the dealership, return
        return dealership;

    }
    public void saveDealership(Dealership dealership) {
        // setting up the file writer to open and write csv efficiently
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            // write dealership information first
            writer.write(dealership.getName() + "|"
                    + dealership.getAddress() + "|"
                    + dealership.getPhone());
            writer.newLine();
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                //vin
                writer.write(String.valueOf(vehicle.getVin()) + "|");
                // year
                writer.write(String.valueOf(vehicle.getYear()) + "|");
                // make
                writer.write(vehicle.getMake() + "|");
                // model
                writer.write(vehicle.getModel() + "|");
                // vehicle type
                writer.write(vehicle.getVehicleType() + "|");
                //color
                writer.write(vehicle.getColor() + "|");
                // odometer
                writer.write(String.valueOf(vehicle.getOdometer()) + "|");
                // price
                writer.write(vehicle.getPrice().toString());
                // move to the next line for the next vehicle
                writer.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
