package edu.iutcs.cr.service;

import edu.iutcs.cr.Invoice;
import edu.iutcs.cr.ShoppingCart;
import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.vehicles.Vehicle;

import java.time.LocalDateTime;

public class InvoiceFormatter {
    
    public void printInvoice(Invoice invoice) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    INVOICE");
        System.out.println("=".repeat(60));
        
        printBuyerInfo(invoice.getBuyer());
        printSellerInfo(invoice.getSeller());
        printPaymentStatus(invoice.isPaid());
        printDateTime(invoice.getDateTime());
        printShoppingCart(invoice.getShoppingCart());
        printTotal(invoice.getShoppingCart());
        
        System.out.println("=".repeat(60) + "\n");
    }
    
    private void printBuyerInfo(Buyer buyer) {
        System.out.println("\nBUYER INFORMATION:");
        System.out.println("  " + buyer.toString());
    }
    
    private void printSellerInfo(Seller seller) {
        System.out.println("\nSELLER INFORMATION:");
        System.out.println("  " + seller.toString());
    }
    
    private void printPaymentStatus(boolean isPaid) {
        System.out.println("\nPAYMENT STATUS: " + (isPaid ? "✓ PAID" : "✗ DUE"));
    }
    
    private void printDateTime(LocalDateTime dateTime) {
        System.out.println("DATE: " + dateTime.toLocalDate() + 
                         " | TIME: " + dateTime.toLocalTime());
    }
    
    private void printShoppingCart(ShoppingCart cart) {
        System.out.println("\nPURCHASED VEHICLES:");
        System.out.println("-".repeat(60));
        
        if (cart.getVehicles().isEmpty()) {
            System.out.println("  No vehicles in cart");
            return;
        }
        
        int count = 1;
        for (Vehicle vehicle : cart.getVehicles()) {
            System.out.println(count++ + ". " + vehicle.toString());
        }
    }
    
    private void printTotal(ShoppingCart cart) {
        double total = cart.getVehicles().stream()
                          .mapToDouble(Vehicle::getPrice)
                          .sum();
        System.out.println("-".repeat(60));
        System.out.println("TOTAL AMOUNT: $" + String.format("%.2f", total));
    }
}

