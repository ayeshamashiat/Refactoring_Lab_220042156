package edu.iutcs.cr.service;


import edu.iutcs.cr.vehicles.Vehicle;
import java.util.Set;

public class InventoryService {
    
    /**
     * Mark all vehicles in a collection as unavailable
     */
    public void markVehiclesAsUnavailable(Set<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            return;
        }
        
        for (Vehicle vehicle : vehicles) {
            vehicle.setUnavailable();
        }
    }
    
    /**
     * Check if a vehicle is available for purchase
     */
    public boolean isVehicleAvailable(Vehicle vehicle) {
        return vehicle != null && vehicle.isAvailable();
    }
    
    /**
     * Calculate total price of vehicles
     */
    public double calculateTotalPrice(Set<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            return 0.0;
        }
        
        return vehicles.stream()
                      .mapToDouble(Vehicle::getPrice)
                      .sum();
    }
}

