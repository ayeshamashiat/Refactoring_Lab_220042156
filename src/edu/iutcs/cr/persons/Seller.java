package edu.iutcs.cr.persons;

import edu.iutcs.cr.service.InputService;
/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Seller extends Person{
    
    private String businessLicense;
    private int salesCount;

    /**
     * Full constructor
     */
    public Seller(String id, String name, String email, String businessLicense) {
        super(id, name, email);
        this.businessLicense = businessLicense;
        this.salesCount = 0;
    }
    
    /**
     * Constructor for lookup
     */
    public Seller(String id) {
        super(id);
    }
    
    /**
     * Static factory method for interactive creation
     */
    public static Seller createFromUserInput(InputService inputService) {
        Person person = Person.createFromUserInput(inputService);
        String license = inputService.readString("Enter business license number: ");
        
        return new Seller(
            person.getId(),
            person.getName(),
            person.getEmail(),
            license
        );
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }
    
    public int getSalesCount() {
        return salesCount;
    }
    
    public void incrementSalesCount() {
        this.salesCount++;
    }

    @Override
    public String toString() {
        return "Seller{" + super.toString() +
                ", businessLicense='" + businessLicense + '\'' +
                ", salesCount=" + salesCount +
                '}';
    }
}
