package edu.iutcs.cr.service;
import edu.iutcs.cr.ShoppingCart;
import edu.iutcs.cr.vehicles.Vehicle;

public class VehicleService {

    public void markVehiclesUnavailable(ShoppingCart cart) {
        for(Vehicle v : cart.getVehicles()) {
            v.setAvailable(false);
        }
    }
}
