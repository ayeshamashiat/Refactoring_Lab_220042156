package edu.iutcs.cr;

import edu.iutcs.cr.service.InputService;
import edu.iutcs.cr.utils.MenuOperation;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class MainMenu {
    
    private final InputService inputService;
    
    public MainMenu() {
        this.inputService = InputService.getInstance();
    }
    
    /**
     * Display menu and get user selection
     */
    public MenuOperation showAndSelectOperation() {
        MenuOperation.displayMenu();
        
        int choice = inputService.readIntInRange(
            "\nEnter your choice: ", 
            1, 
            MenuOperation.values().length
        );
        
        return MenuOperation.fromCode(choice);
    }
}
