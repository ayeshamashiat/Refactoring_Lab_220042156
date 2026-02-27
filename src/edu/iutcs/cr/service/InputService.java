package edu.iutcs.cr.service;

import java.util.Scanner;

public class InputService {
    
    private static InputService instance;
    private final Scanner scanner;
    
    private InputService() {
        this.scanner = new Scanner(System.in);
    }
    
    public static InputService getInstance() {
        if (instance == null) {
            instance = new InputService();
        }
        return instance;
    }
    
    /**
     * Read a mandatory string input with validation
     */
    public String readMandatoryString(String prompt, String fieldName) {
        String input = null;
        while (input == null || input.isBlank()) {
            System.out.print(prompt);
            input = scanner.nextLine();
            
            if (input == null || input.isBlank()) {
                System.out.println(fieldName + " is mandatory!");
            }
        }
        return input.trim();
    }
    
    /**
     * Read an optional string input
     */
    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    /**
     * Read an integer with validation
     */
    public int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer!");
            scanner.next(); // consume invalid input
            System.out.print(prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }
    
    /**
     * Read an integer within a range
     */
    public int readIntInRange(String prompt, int min, int max) {
        int value;
        do {
            value = readInt(prompt);
            if (value < min || value > max) {
                System.out.println("Please enter a value between " + min + " and " + max);
            }
        } while (value < min || value > max);
        return value;
    }
    
    /**
     * Read a double value
     */
    public double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid number!");
            scanner.next();
            System.out.print(prompt);
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return value;
    }
    
    /**
     * Read a boolean value
     */
    public boolean readBoolean(String prompt) {
        System.out.print(prompt + " (true/false): ");
        while (!scanner.hasNextBoolean()) {
            System.out.println("Please enter true or false!");
            scanner.next();
            System.out.print(prompt + " (true/false): ");
        }
        boolean value = scanner.nextBoolean();
        scanner.nextLine(); // consume newline
        return value;
    }
    
    /**
     * Wait for user to press a specific key to continue
     */
    public void waitForKey(int key) {
        System.out.print("\n\nEnter " + key + " to continue: ");
        int val = -1;
        do {
            val = readInt("");
        } while (val != key);
    }
}
