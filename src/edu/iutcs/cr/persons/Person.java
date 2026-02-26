package edu.iutcs.cr.persons;
/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public abstract class Person {

    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
