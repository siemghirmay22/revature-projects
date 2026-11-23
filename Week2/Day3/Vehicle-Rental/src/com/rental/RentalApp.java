package com.rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = readInt(sc);

        // One list of the PARENT type holds both Cars and Bikes
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Keep asking until the user enters a valid type (1 or 2)
            int type;
            while (true) {
                System.out.print("Enter type (1-Car, 2-Bike): ");
                type = readInt(sc);
                if (type == 1 || type == 2) break;
                System.out.println("Invalid vehicle type! Please enter 1 for Car or 2 for Bike.");
            }

            System.out.print("Enter Vehicle Number: ");
            String number = sc.nextLine().trim();

            System.out.print("Enter Model: ");
            String model = sc.nextLine().trim();

            System.out.print("Enter Rate per Day: ");
            double rate = readDouble(sc);

            System.out.print("Enter Days: ");
            int days = readInt(sc);

            // POLYMORPHISM: parent-type reference pointing to a child object
            Vehicle v;
            if (type == 1) {
                System.out.print("Enter Insurance per Day: ");
                double insurance = readDouble(sc);
                v = new Car(number, model, rate, days, insurance);
            } else {
                v = new Bike(number, model, rate, days);
            }
            vehicles.add(v);
        }

        System.out.println();
        System.out.println("--- Rental Details ---");

        double total = 0;
        for (Vehicle v : vehicles) {
            // RUNTIME POLYMORPHISM: Car's or Bike's overridden method runs
            v.displayDetails();
            total += v.calculateRent();
        }

        System.out.println();
        System.out.println("Total Rent Collected: " + total);

        sc.close();   // close the Scanner at the end
    }

    // Reads a whole line and converts it to int; asks again on bad input
    private static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a whole number: ");
            }
        }
    }

    // Reads a whole line and converts it to double; asks again on bad input
    private static double readDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }
}