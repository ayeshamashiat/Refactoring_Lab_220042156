package edu.iutcs.cr;

import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import java.time.LocalDateTime;
import edu.iutcs.cr.service.InventoryService;
import edu.iutcs.cr.service.PaymentService;
import java.io.Serializable;

public class Invoice implements Serializable {

    private final Buyer buyer;
    private final Seller seller;
    private final ShoppingCart shoppingCart;
    private boolean isPaid;
    private final LocalDateTime dateTime;
    private final double totalAmount;

    /**
     * Constructor - creates invoice and processes payment
     */
    public Invoice(Buyer buyer, Seller seller, ShoppingCart shoppingCart,
                   PaymentService paymentService, InventoryService inventoryService) {
        this.buyer = buyer;
        this.seller = seller;
        this.shoppingCart = shoppingCart;
        this.dateTime = LocalDateTime.now();
        
        // Calculate total
        this.totalAmount = inventoryService.calculateTotalPrice(shoppingCart.getVehicles());
        
        // Process payment through service
        this.isPaid = paymentService.processPayment(this.totalAmount);
        
        // Mark vehicles as unavailable if payment successful
        if (this.isPaid) {
            inventoryService.markVehiclesAsUnavailable(shoppingCart.getVehicles());
        }
    }

    // Getters - Invoice is now a pure data holder
    public Buyer getBuyer() {
        return buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
}
