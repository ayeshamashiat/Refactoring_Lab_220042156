package edu.iutcs.cr.vehicles;

import edu.iutcs.cr.service.InputService;
/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SUV extends Vehicle{

    private boolean isOffRoad;

    public SUV(String registrationNumber, String make, String model, 
               String year, double price, boolean isOffRoad) {
        super(registrationNumber, make, model, year, price);
        this.isOffRoad = isOffRoad;
    }

    public SUV(InputService inputService) {
        super("");
        initializeFromUserInput(inputService);
        this.isOffRoad = inputService.readBoolean("Is the SUV for off-road use?");
    }

    public boolean isOffRoad() {
        return isOffRoad;
    }

    public void setOffRoad(boolean offRoad) {
        isOffRoad = offRoad;
    }

    @Override
    public String toString() {
        return "SUV{" + super.toString() + 
                ", isOffRoad=" + isOffRoad + '}';
    }
}
