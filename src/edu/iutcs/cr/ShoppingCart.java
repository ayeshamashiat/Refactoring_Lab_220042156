package edu.iutcs.cr;
import edu.iutcs.cr.vehicles.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */


public class ShoppingCart {

    private List<Vehicle> vehicles;

    public ShoppingCart() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}