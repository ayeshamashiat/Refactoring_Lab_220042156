package edu.iutcs.cr.vehicles;

import edu.iutcs.cr.service.InputService;
/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Car extends Vehicle{

    private int seatingCapacity;

    /**
     * Full constructor
     */
    public Car(String registrationNumber, String make, String model, 
               String year, double price, int seatingCapacity) {
        super(registrationNumber, make, model, year, price);
        this.seatingCapacity = seatingCapacity;
    }
    
    /**
     * Constructor for interactive creation
     */
    public Car(InputService inputService) {
        super("");
        initializeFromUserInput(inputService);
        this.seatingCapacity = inputService.readInt("Enter seating capacity: ");
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() + 
                ", seatingCapacity=" + seatingCapacity + '}';
    }
}
