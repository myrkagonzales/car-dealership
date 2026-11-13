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

}
