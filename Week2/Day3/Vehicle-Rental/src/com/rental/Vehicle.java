package com.rental;

/**
 * Base (parent) class for every rentable vehicle.
 *
 * INHERITANCE: Car and Bike extend this class, so they reuse these fields
 * and the base calculateRent()/displayDetails() logic instead of rewriting it.
 */
public class Vehicle {

    protected String vehicleNumber;
    protected String model;
    protected double ratePerDay;
    protected int days;

    public Vehicle(String vehicleNumber, String model, double ratePerDay, int days) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.ratePerDay = ratePerDay;
        this.days = days;
    }

    /** Base rent = ratePerDay x days. Subclasses override this (polymorphism). */
    public double calculateRent() {
        return ratePerDay * days;
    }

    /** Prints one line of rental details. Subclasses override this (polymorphism). */
    public void displayDetails() {
        System.out.println("Vehicle | " + vehicleNumber + " | " + model
                + " | Days: " + days + " | Rent: " + calculateRent());
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getModel()         { return model; }
    public double getRatePerDay()    { return ratePerDay; }
    public int getDays()             { return days; }
}
