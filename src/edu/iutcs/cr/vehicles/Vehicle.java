package edu.iutcs.cr.vehicles;

import java.io.Serializable;
import java.util.Objects;
import edu.iutcs.cr.service.InputService;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Vehicle implements Serializable {

    private String make;
    private String model;
    private String year;
    private double price;
    private boolean available;
    private String registrationNumber;

    public Vehicle(String registrationNumber, String make, String model, 
                   String year, double price) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.available = true;
    }
   
    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    protected void initializeFromUserInput(InputService inputService) {
        this.registrationNumber = inputService.readMandatoryString(
            "Enter registration number: ", "Registration number");
        this.make = inputService.readMandatoryString(
            "Enter make: ", "Make");
        this.model = inputService.readMandatoryString(
            "Enter model: ", "Model");
        this.year = inputService.readMandatoryString(
            "Enter year: ", "Year");
        this.price = inputService.readDouble("Enter price: $");
        this.available = true;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    // Business logic methods
    public void setUnavailable() {
        this.available = false;
    }
    
    public void setAvailable() {
        this.available = true;
    }
    
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", price=$" + String.format("%.2f", price) +
                ", available=" + available +
                ", registrationNumber='" + registrationNumber + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(registrationNumber, vehicle.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}
