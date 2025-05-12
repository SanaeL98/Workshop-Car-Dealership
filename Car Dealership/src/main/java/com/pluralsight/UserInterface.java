package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public void display() {
        init(); // Load dealership from file

        int choice;
        do {
            System.out.println("\n===== DEALERSHIP MENU =====");
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Find vehicles within a price range");
            System.out.println("99 - Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    processAllVehiclesRequest();
                    break;
                case 2:
                    processPriceRangeRequest();
                    break;
                case 99:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 99);
    }


    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();

        if (this.dealership == null) {
            System.out.println("ERROR: Dealership not loaded. Check file path.");
        }
    }


    private void processAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }


    private void processPriceRangeRequest() {
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();

        List<Vehicle> results = dealership.getVehiclesByPrice(min, max);
        displayVehicles(results);
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        for (Vehicle v : vehicles) {
            System.out.printf("VIN: %d | %d %s %s | %s | %s | %,d miles | $%,.2f%n",
                    v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                    v.getColor(), v.getVehicleType(), v.getOdometer(), v.getPrice());
        }
    }
}
