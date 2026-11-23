package com.rental;

/**
 * A Bike IS-A Vehicle.
 *
 * INHERITANCE: extends Vehicle and calls the parent constructor with super(...).
 * POLYMORPHISM: overrides calculateRent() to apply a 10% discount,
 *               and overrides displayDetails() to print "Bike".
 */
public class Bike extends Vehicle {

    private static final double DISCOUNT = 0.10;   // 10% off total rent

    public Bike(String vehicleNumber, String model, double ratePerDay, int days) {
        super(vehicleNumber, model, ratePerDay, days);   // INHERITANCE: parent constructor
    }

    @Override   // POLYMORPHISM: method overriding
    public double calculateRent() {
        // Reuse the parent's base rent, then take 10% off
        return super.calculateRent() * (1 - DISCOUNT);
    }

    @Override   // POLYMORPHISM: method overriding
    public void displayDetails() {
        System.out.println("Bike | " + vehicleNumber + " | " + model
                + " | Days: " + days + " | Rent: " + calculateRent());
    }
}
