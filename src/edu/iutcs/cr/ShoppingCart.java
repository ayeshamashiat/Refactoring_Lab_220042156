package edu.iutcs.cr;
import edu.iutcs.cr.service.InputService;
import edu.iutcs.cr.service.InventoryService;
import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.vehicles.Vehicle;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Raian Rahman
 * @since 4/19/2024
 */


public class ShoppingCart implements Serializable {

    private final Set<Vehicle> vehicles;
    private final SystemDatabase database;
    private final InventoryService inventoryService;

    public ShoppingCart() {
        this.vehicles = new HashSet<>();
        this.database = SystemDatabase.getInstance();
        this.inventoryService = new InventoryService();
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Add item to cart with validation
     */
    public void addItem(InputService inputService) {
        System.out.print("Enter registration number of vehicle: ");
        String registrationNumber = inputService.readString("");
        
        Vehicle vehicle = database.findVehicleByRegistrationNumber(registrationNumber);
        
        if (!inventoryService.isVehicleAvailable(vehicle)) {
            System.out.println("Vehicle not available");
            return;
        }
        
        vehicles.add(vehicle);
        System.out.println("Vehicle added to cart successfully!");
    }

    /**
     * Remove item from cart
     */
    public void removeItem(InputService inputService) {
        System.out.print("Enter the registration number of the vehicle: ");
        String registrationNumber = inputService.readString("");
        
        boolean removed = vehicles.remove(new Vehicle(registrationNumber));
        if (removed) {
            System.out.println("Vehicle removed from cart successfully!");
        } else {
            System.out.println("Vehicle not found in cart!");
        }
    }

    /**
     * Display cart contents
     */
    public void viewCart() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                 SHOPPING CART");
        System.out.println("=".repeat(60));

        if (vehicles.isEmpty()) {
            System.out.println("Cart is empty");
            System.out.println("=".repeat(60) + "\n");
            return;
        }

        int count = 1;
        for (Vehicle vehicle : vehicles) {
            System.out.println(count++ + ". " + vehicle.toString());
        }
        
        double total = inventoryService.calculateTotalPrice(vehicles);
        System.out.println("-".repeat(60));
        System.out.println("TOTAL: $" + String.format("%.2f", total));
        System.out.println("=".repeat(60) + "\n");
    }
    
    /**
     * Check if cart is empty
     */
    public boolean isEmpty() {
        return vehicles.isEmpty();
    }
}
