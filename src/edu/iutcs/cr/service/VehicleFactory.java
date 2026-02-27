package edu.iutcs.cr.service;

import edu.iutcs.cr.vehicles.*;

public class VehicleFactory {
    
    public enum VehicleType {
        BUS(1, "Bus"),
        CAR(2, "Car"),
        HATCHBACK(3, "Hatchback"),
        SEDAN(4, "Sedan"),
        SUV(5, "SUV");
        
        private final int code;
        private final String displayName;
        
        VehicleType(int code, String displayName) {
            this.code = code;
            this.displayName = displayName;
        }
        
        public int getCode() {
            return code;
        }
        
        public String getDisplayName() {
            return displayName;
        }
        
        public static VehicleType fromCode(int code) {
            for (VehicleType type : values()) {
                if (type.code == code) {
                    return type;
                }
            }
            return null;
        }
    }
    
    /**
     * Create a vehicle based on type code
     */
    public Vehicle createVehicle(int typeCode, InputService inputService) {
        VehicleType type = VehicleType.fromCode(typeCode);
        if (type == null) {
            throw new IllegalArgumentException("Invalid vehicle type code: " + typeCode);
        }
        
        return createVehicle(type, inputService);
    }
    
    /**
     * Create a vehicle based on enum type
     */
    public Vehicle createVehicle(VehicleType type, InputService inputService) {
        System.out.println("\n\nCreating new " + type.getDisplayName());
        
        switch (type) {
            case BUS:
                return new Bus(inputService);
            case CAR:
                return new Car(inputService);
            case HATCHBACK:
                return new Hatchback(inputService);
            case SEDAN:
                return new Sedan(inputService);
            case SUV:
                return new SUV(inputService);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
    
    /**
     * Display available vehicle types
     */
    public void displayVehicleTypes() {
        System.out.println("Please select vehicle type:");
        for (VehicleType type : VehicleType.values()) {
            System.out.println(type.getCode() + ". " + type.getDisplayName());
        }
    }
}
