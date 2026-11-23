package com.rental;

/**
 * A Car IS-A Vehicle.
 *
 * INHERITANCE: extends Vehicle and calls the parent constructor with super(...).
 * POLYMORPHISM: overrides calculateRent() to add an insurance charge per day,
 *               and overrides displayDetails() to print "Car".
 */
public class Car extends Vehicle {

    private double insurancePerDay;

    public Car(String vehicleNumber, String model, double ratePerDay, int days, double insurancePerDay) {
        super(vehicleNumber, model, ratePerDay, days);   // INHERITANCE: parent constructor
        this.insurancePerDay = insurancePerDay;
    }

    @Override   // POLYMORPHISM: method overriding
    public double calculateRent() {
        // Reuse the parent's base rent, then add insurance for each day
        return super.calculateRent() + (insurancePerDay * days);
    }

    @Override   // POLYMORPHISM: method overriding
    public void displayDetails() {
        System.out.println("Car | " + vehicleNumber + " | " + model
                + " | Days: " + days + " | Rent: " + calculateRent());
    }

    public double getInsurancePerDay() { return insurancePerDay; }
}
