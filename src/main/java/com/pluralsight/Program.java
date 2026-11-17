package com.pluralsight;

public class Program {

    public static void main(String[] args) {
        // create the file manager to read  the inventory file
        DealershipFileManager fileManager = new DealershipFileManager();

        // load the dealership and its vehicle from the csv file
        Dealership dealership = fileManager.getDealership();

        // check whether the dealership was successfully loaded
        if (dealership == null) {
            System.out.println("Unable to load dealership inventory.");
            return;
        }
        // create the user interface and conenct it to the dealership
        UserInterface userInterface = new UserInterface(dealership);
        // start displaying the dealership menu
        userInterface.display();
    }
}
