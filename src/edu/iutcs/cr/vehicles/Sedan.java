package edu.iutcs.cr.vehicles;

import edu.iutcs.cr.service.InputService;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class Sedan extends Vehicle{

    private boolean hasSunroof;

    /**
     * Full constructor
     */
    public Sedan(String registrationNumber, String make, String model, 
                 String year, double price, boolean hasSunroof) {
        super(registrationNumber, make, model, year, price);
        this.hasSunroof = hasSunroof;
    }
    
    /**
     * Constructor for interactive creation
     */
    public Sedan(InputService inputService) {
        super("");
        initializeFromUserInput(inputService);
        this.hasSunroof = inputService.readBoolean("Does the sedan have a sunroof?");
    }

    public boolean hasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    @Override
    public String toString() {
        return "Sedan{" + super.toString() + 
                ", hasSunroof=" + hasSunroof + '}';
    }
}
