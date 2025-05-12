package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("inventory.csv");

            if (input == null) {
                System.out.println("ERROR: inventory.csv not found!");
                return null;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));


            String line = reader.readLine();
            String[] parts = line.split("\\|");
            dealership = new Dealership(parts[0], parts[1], parts[2]);



            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // skip empty lines
                }

                String[] tokens = line.split("\\|");

                if (tokens.length < 8) {
                    System.out.println("Skipping invalid line: " + line);
                    continue; // not enough fields
                }

                Vehicle vehicle = new Vehicle(
                        Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[1]),
                        tokens[2],
                        tokens[3],
                        tokens[4],
                        tokens[5],
                        Integer.parseInt(tokens[6]),
                        Double.parseDouble(tokens[7])
                );

                dealership.addVehicle(vehicle);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return dealership;
    }
}