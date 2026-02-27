package edu.iutcs.cr.persons;

import edu.iutcs.cr.service.InputService;
import java.io.Serializable;
import java.util.Objects;
/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Person implements Serializable {

    private String name;
    private String id;
    private String email;

    /**
     * Constructor with all parameters - for programmatic creation
     */
    public Person(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    /**
     * Constructor with ID only - for lookup/search
     */
    public Person(String id) {
        this.id = id;
    }
    
    /**
     * Static factory method for interactive creation
     */
    public static Person createFromUserInput(InputService inputService) {
        String name = inputService.readMandatoryString("Enter name: ", "Name");
        String id = inputService.readMandatoryString("Enter ID: ", "ID");
        String email = inputService.readMandatoryString("Enter email: ", "Email");
        return new Person(id, name, email);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    
    // Setters for programmatic updates
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
