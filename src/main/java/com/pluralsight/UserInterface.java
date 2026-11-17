package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    // stores the dealership so we can access its inventory and methods
    private Dealership dealership;

    // reads information entered by the user
    private Scanner scanner;

    // handles reading and saving inventory
    private DealershipFileManager fileManager = new DealershipFileManager();

    // constructor
    public UserInterface(Dealership dealership) {
        // save the dealership object in class field
        this.dealership = dealership;
        //set up scanner to read input
        this.scanner = new Scanner(System.in);
    }

    // displaying dealership Menu
    public void displayMenu() {

        // print the menu header
        System.out.println("\n===== MENU =====");

        // DISPLAY THE OPTIONS
        System.out.println("1. Find vehicles by price: ");
        System.out.println("2. Find vehicles by make/model: ");
        System.out.println("3. Find vehicles by year: ");
        System.out.println("4. Find vehicles by mileage: ");
        System.out.println("5.Find vehicles by type: ");
        System.out.println("6. View all vehicles: ");
        System.out.println("7. Add a vehicle: ");
        System.out.println("8. Remove a vehicle: ");
        System.out.println("9. Quit: ");

        // ask the user to choose an option
        System.out.print("Enter your choice: ");
    }

    // gets the menu choice entered by the user
    public int promptChoice() {

        // read the number entered by the user
        int choice = scanner.nextInt();

        // return users choice
        return choice;

    }

    // Processes users choice
    public void userChoice(int choice) {

        // check which menu option the user selected
        switch (choice) {
            case 1:
                // ask the user for min and max price
                System.out.print("Enter the minimum price: ");
                int minPrice = scanner.nextInt();
                System.out.print("Enter the maximum price: ");
                int maxPrice = scanner.nextInt();
                ArrayList<Vehicle> priceResults = dealership.getVehiclesByPrice(minPrice, maxPrice);

                // check whether any matches match the search
                if (priceResults.isEmpty()) {
                    System.out.println("No vehicles found in that price range. ");
                } else {
                    //display each matching vehicle
                    for (Vehicle vehicle : priceResults) {
                        System.out.println("------------------");
                        System.out.println("VIN: " + vehicle.getVin());
                        System.out.println("Year: " + vehicle.getYear());
                        System.out.println("Make: " + vehicle.getMake());
                        System.out.println("Model " + vehicle.getModel());
                        System.out.println("Price: $" + vehicle.getPrice());
                    }
                }
                break;
            // ask for vehicle model
            case 2:

                System.out.print("Enter vehicle model: ");
                String model = scanner.next();

                System.out.print("Enter vehicle model: ");
                String make = scanner.next();

                // search the dealership inventory
                ArrayList<Vehicle> makeModelResults = dealership.getVehiclesByMakeModel(make, model);

                // check whether any searches matched
                if (makeModelResults.isEmpty()) {
                    System.out.println("No vehicles found matching that make and model. ");
                } else {
                    for (Vehicle vehicle : makeModelResults) {
                        System.out.println("------------------");
                        System.out.println("VIN: " + vehicle.getVin());
                        System.out.println("Year: " + vehicle.getYear());
                        System.out.println("Make: " + vehicle.getMake());
                        System.out.println("Model " + vehicle.getModel());
                        System.out.println("Price: $" + vehicle.getPrice());

                    }
                }
                break;
            case 3:
                System.out.print("Enter the minimum year: ");
                int minYear = scanner.nextInt();
                // ask the user for the ending year
                System.out.print("Enter the maximum year: ");
                int maxYear = scanner.nextInt();
                ArrayList<Vehicle> yearResults = dealership.getVehiclesByYear(minYear, maxYear);

                if (yearResults.isEmpty()) {
                    System.out.println("No vehicles found within that year range. ");
                } else {
                    for (Vehicle vehicle : yearResults) {

                        System.out.println("------------------");
                        System.out.println("VIN: " + vehicle.getVin());
                        System.out.println("Year: " + vehicle.getYear());
                        System.out.println("Make: " + vehicle.getMake());
                        System.out.println("Model " + vehicle.getModel());
                        System.out.println("Price: $" + vehicle.getPrice());
                    }
                }
                break;
            case 4:
                System.out.print("Enter the minimum mileage: ");
                int minmileage = scanner.nextInt();
                System.out.print("Enter the maximum mileage: ");
                int maxmileage = scanner.nextInt();
                ArrayList<Vehicle> mileageResults = dealership.getVehiclesByMileage(minmileage, maxmileage);

                if (mileageResults.isEmpty()) {
                    System.out.println("No vehicles found within mileage range");
                } else {
                    for (Vehicle vehicle : mileageResults) {

                        System.out.println("------------------------");
                        System.out.println("VIN: " + vehicle.getVin());
                        System.out.println("Year: " + vehicle.getYear());
                        System.out.println("Make: " + vehicle.getMake());
                        System.out.println("Model: " + vehicle.getModel());
                        System.out.println("Type: " + vehicle.getVehicleType());
                        System.out.println("Color: " + vehicle.getColor());
                        System.out.println("Odometer: " + vehicle.getOdometer());
                        System.out.println("Price $" + vehicle.getPrice());
                    }
                }
                break;
            case 5:
                System.out.print("Enter the vehicle type (e.g. Sudan, Suv, Truck, etc...");
                String type = scanner.next();
                ArrayList<Vehicle> typeResults = dealership.getVehiclesbyType(type);

                if (typeResults.isEmpty()) {
                    System.out.println("No vehicles found within search criteria.");
                } else {
                    for (Vehicle vehicle : typeResults) {

                    }
                }

                break;
            case 6:
                ArrayList<Vehicle> vehicles = dealership.getAllVehicles();


                //  check whether the dealership has any vehicles
                if (vehicles.isEmpty()) {
                    System.out.println("There are no vehicles in inventory. ");
                } else {
                    // display each vehicle in the inventory
                    for (Vehicle vehicle : vehicles) {
                        System.out.println("------------------------");
                        System.out.println("VIN: " + vehicle.getVin());
                        System.out.println("Year: " + vehicle.getYear());
                        System.out.println("Make: " + vehicle.getMake());
                        System.out.println("Model: " + vehicle.getModel());
                        System.out.println("Type: " + vehicle.getVehicleType());
                        System.out.println("Color: " + vehicle.getColor());
                        System.out.println("Odometer: " + vehicle.getOdometer());
                        System.out.println("Price $" + vehicle.getPrice());
                    }
                }
                break;

            case 7:
                // ask the user to enter vehicle information
                System.out.print("Enter VIN: ");
                int vin = scanner.nextInt();
                System.out.print("Enter year: ");
                int year = scanner.nextInt();
                System.out.print("Enter make: ");
                String vehMake = scanner.next();
                System.out.print("Enter model: ");
                String vehModel = scanner.next();
                System.out.print("Enter vehicle type: ");
                String vehicleType = scanner.next();
                System.out.print("Enter color: ");
                String color = scanner.next();
                System.out.print("Enter the odometer reading: ");
                int odometer = scanner.nextInt();
                System.out.print("Enter price: ");
                BigDecimal price = scanner.nextBigDecimal();

                Vehicle newVehicle = new Vehicle(vin, year, vehMake, vehModel, vehicleType, color, odometer, price);
                // add new vehicle to inventory
                dealership.addVehicle(newVehicle);
                // save the updated dealership inventory to csv file
                fileManager.saveDealership(dealership);
                // let the user know the vehicle was added
                System.out.println("Vehicle successfully added!");
                break;
            case 8:
                // ask the user for the vin of the vehicle they want to remove
                System.out.print("Enter the VIN of the vehicle to remove: ");
                int vinRemoval = scanner.nextInt();

                // create a variable to hold the vehicle we want to remove
                Vehicle vehicleRemoval = null;

                // loop through the inventory
                for (Vehicle currentVehicle : dealership.getAllVehicles()) {
                    //check whether this vehicles vin matches the entered VIN
                    if (currentVehicle.getVin() == vinRemoval) {
                        //store the matching vehicle
                        vehicleRemoval = currentVehicle;
                        // stop searching once found
                        break;
                    }
                }
                // check if vehicle was found
                if (vehicleRemoval != null) {
                    // remove the vehicle from inventory
                    dealership.removeVehicle(vehicleRemoval);
                    //save the updated inventory to csv
                    fileManager.saveDealership(dealership);
                    // confirm the removal
                    System.out.println("Vehicle successfully removed!");
                } else {
                    // let the user know if the vin was not found
                    System.out.println("Vehicle not found.");
                }
                break;
            case 9:
                System.out.println("Thank you for visiting!");
                break;


        }
    }

    // run the menu until user chooses to quit
    public void display() {

        // store the users menu choice
        int choice;

        //keep showing the menu until the user enters 9
        do {
            // display the menu
            displayMenu();
            //get users selection
            choice = promptChoice();

            userChoice(choice);
        } while (choice != 9);
    }
}


