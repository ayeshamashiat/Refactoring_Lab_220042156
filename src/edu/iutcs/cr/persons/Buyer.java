package edu.iutcs.cr.persons;

import edu.iutcs.cr.service.InputService;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Buyer extends Person{

    private String paymentMethod;

    public Buyer(String id, String name, String email, String paymentMethod) {
        super(id, name, email);
        this.paymentMethod = paymentMethod;
    }
    
    public Buyer(String id) {
        super(id);
    }
    
    public static Buyer createFromUserInput(InputService inputService) {
        Person person = Person.createFromUserInput(inputService);
        String paymentMethod = inputService.readString("Enter payment method: ");
        
        return new Buyer(
            person.getId(),
            person.getName(),
            person.getEmail(),
            paymentMethod
        );
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Buyer{" + super.toString() +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
