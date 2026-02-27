package edu.iutcs.cr.vehicles;

import edu.iutcs.cr.service.InputService    ;
/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class Hatchback extends Vehicle{

    private boolean isCompact;

    /**
     * Full constructor
     */
    public Hatchback(String registrationNumber, String make, String model, 
                     String year, double price, boolean isCompact) {
        super(registrationNumber, make, model, year, price);
        this.isCompact = isCompact;
    }
    
    /**
     * Constructor for interactive creation
     */
    public Hatchback(InputService inputService) {
        super("");
        initializeFromUserInput(inputService);
        this.isCompact = inputService.readBoolean("Is the hatchback compact?");
    }

    public boolean isCompact() {
        return isCompact;
    }

    public void setCompact(boolean compact) {
        isCompact = compact;
    }

    @Override
    public String toString() {
        return "Hatchback{" + super.toString() + 
                ", isCompact=" + isCompact + '}';
    }
}

