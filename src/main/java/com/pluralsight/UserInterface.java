package com.pluralsight;
import java.util.Scanner;

public class UserInterface {
    // stores the dealership so we can access its inventory and methods
    private Dealership dealership;

    // reads information entered by the user
    private Scanner scanner;

    // constructor
    public UserInterface(Dealership dealership) {
        // save the dealership object in class field
        this.dealership = dealership;
        //set up scanner to read input
        this.scanner = new Scanner(System.in);
    }

    // dispalying dealership Menu
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
                System.out.println("Search vehicles by price");
                break;
            case 2:
                System.out.println("Search vehicles by make and model");
                break;
            case 3:
                System.out.println("Search vehicles by year");
                break;
            case 4:
                System.out.println("Search vehicles by mileage");
                break;
            case 5:
                System.out.println("Search vehicles by type");
                break;
            case 6:
                System.out.println("View all vehicles");
                break;
            case 7:
                System.out.println("Add a vehicle");
                break;
            case 8:
                System.out.println("Remove a vehicle");
                break;
            case 9:
                System.out.println("Thank you for visiting!");
                break;


        }
    }
    }


