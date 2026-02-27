package edu.iutcs.cr;
import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.service.*;
import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.utils.MenuOperation;
import edu.iutcs.cr.vehicles.Vehicle;

public class ApplicationController {
    
    private final SystemDatabase database;
    private final MainMenu mainMenu;
    private final InputService inputService;
    private final VehicleFactory vehicleFactory;
    private final PaymentService paymentService;
    private final InventoryService inventoryService;
    private final InvoiceFormatter invoiceFormatter;

    public ApplicationController() {
        this.database = SystemDatabase.getInstance();
        this.mainMenu = new MainMenu();
        this.inputService = InputService.getInstance();
        this.vehicleFactory = new VehicleFactory();
        this.paymentService = new PaymentService();
        this.inventoryService = new InventoryService();
        this.invoiceFormatter = new InvoiceFormatter();
    }

    /**
     * Main application loop
     */
    public void run() {
        System.out.println("\n╔" + "═".repeat(50) + "╗");
        System.out.println("║" + " ".repeat(15) + "WELCOME TO CAR HUT" + " ".repeat(17) + "║");
        System.out.println("╚" + "═".repeat(50) + "╝\n");

        System.out.println("Loading existing system...");
        System.out.println("System loaded successfully!\n");

        while (true) {
            MenuOperation operation = mainMenu.showAndSelectOperation();
            
            if (operation == MenuOperation.EXIT) {
                database.saveSystem();
                System.out.println("\nThank you for using Car Hut. Goodbye!");
                return;
            }
            
            handleOperation(operation);
        }
    }
    
    /**
     * Handle menu operation
     */
    private void handleOperation(MenuOperation operation) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(operation.getDescription().toUpperCase());
        System.out.println("=".repeat(60) + "\n");
        
        switch (operation) {
            case ADD_SELLER:
                addSeller();
                break;
            case ADD_BUYER:
                addBuyer();
                break;
            case ADD_VEHICLE:
                addVehicle();
                break;
            case VIEW_INVENTORY:
                database.showInventory();
                break;
            case VIEW_SELLERS:
                database.showSellerList();
                break;
            case VIEW_BUYERS:
                database.showBuyerList();
                break;
            case CREATE_ORDER:
                createOrder();
                return; 
            case VIEW_INVOICES:
                database.showInvoices();
                break;
            default:
                System.out.println("Invalid operation!");
                return;
        }
        
        promptToViewMainMenu();
    }
    
    /**
     * Add a new seller
     */
    private void addSeller() {
        Seller seller = Seller.createFromUserInput(inputService);
        database.getSellers().add(seller);
        System.out.println("\n✓ Seller added successfully!");
    }
    
    /**
     * Add a new buyer
     */
    private void addBuyer() {
        Buyer buyer = Buyer.createFromUserInput(inputService);
        database.getBuyers().add(buyer);
        System.out.println("\n✓ Buyer added successfully!");
    }
    
    /**
     * Add a new vehicle using factory
     */
    private void addVehicle() {
        vehicleFactory.displayVehicleTypes();
        
        int vehicleType = inputService.readIntInRange(
            "\nEnter your choice: ", 
            1, 
            VehicleFactory.VehicleType.values().length
        );
        
        Vehicle vehicle = vehicleFactory.createVehicle(vehicleType, inputService);
        database.getVehicles().add(vehicle);
        System.out.println("\n✓ Vehicle added successfully!");
    }
    
    /**
     * Create a new order
     */
    private void createOrder() {
        ShoppingCart cart = new ShoppingCart();
        
        while (true) {
            displayOrderMenu();
            int choice = inputService.readIntInRange("Enter your choice: ", 1, 5);
            
            if (choice == 1) {
                cart.addItem(inputService);
            } else if (choice == 2) {
                cart.removeItem(inputService);
            } else if (choice == 3) {
                cart.viewCart();
            } else if (choice == 4) {
                if (cart.isEmpty()) {
                    System.out.println("Cart is empty! Add items before checkout.");
                    continue;
                }
                createInvoice(cart);
                return;
            } else {
                return; // Return to main menu
            }
        }
    }
    
    /**
     * Display order/cart menu
     */
    private void displayOrderMenu() {
        System.out.println("\n╔" + "═".repeat(50) + "╗");
        System.out.println("║" + " ".repeat(16) + "SHOPPING CART MENU" + " ".repeat(16) + "║");
        System.out.println("╠" + "═".repeat(50) + "╣");
        System.out.println("║ 1.  Add vehicle to cart                         ║");
        System.out.println("║ 2.  Remove vehicle from cart                    ║");
        System.out.println("║ 3.  View cart                                    ║");
        System.out.println("║ 4.  Proceed to checkout                          ║");
        System.out.println("║ 5.  Return to main menu                          ║");
        System.out.println("╚" + "═".repeat(50) + "╝\n");
    }
    
    /**
     * Create invoice with buyer and seller
     */
    private void createInvoice(ShoppingCart cart) {
        Buyer buyer = findBuyer();
        if (buyer == null) return;
        
        Seller seller = findSeller();
        if (seller == null) return;
        
        // Create invoice with services
        Invoice invoice = new Invoice(
            buyer, 
            seller, 
            cart, 
            paymentService, 
            inventoryService
        );
        
        // Display invoice
        invoiceFormatter.printInvoice(invoice);
        
        // Save to database
        database.getInvoices().add(invoice);
        
        // Update seller stats
        seller.incrementSalesCount();
        
        System.out.println("\n✓ Order completed successfully!");
        promptToViewMainMenu();
    }
    
    /**
     * Find and validate buyer
     */
    private Buyer findBuyer() {
        Buyer buyer = null;
        while (buyer == null) {
            String buyerId = inputService.readString("Enter buyer ID: ");
            buyer = database.findBuyerById(buyerId);
            
            if (buyer == null) {
                System.out.println("❌ Buyer not found. Please try again!");
            }
        }
        return buyer;
    }
    
    /**
     * Find and validate seller
     */
    private Seller findSeller() {
        Seller seller = null;
        while (seller == null) {
            String sellerId = inputService.readString("Enter seller ID: ");
            seller = database.findSellerById(sellerId);
            
            if (seller == null) {
                System.out.println("❌ Seller not found. Please try again!");
            }
        }
        return seller;
    }
  
    private void promptToViewMainMenu() {
        inputService.waitForKey(0);
    }
}

