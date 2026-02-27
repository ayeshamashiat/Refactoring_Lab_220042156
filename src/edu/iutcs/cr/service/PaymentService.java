package edu.iutcs.cr.service;


public class PaymentService {
    
    private final InputService inputService;
    
    public PaymentService() {
        this.inputService = InputService.getInstance();
    }
    
    /**
     * Process payment for an invoice
     * Returns true if payment is successful
     */
    public boolean processPayment(double amount) {
        System.out.println("\nProcessing payment of $" + amount);
        return inputService.readBoolean("Is payment completed?");
    }
    
    /**
     * Validate payment method
     */
    public boolean isValidPaymentMethod(String paymentMethod) {
        if (paymentMethod == null || paymentMethod.isBlank()) {
            return false;
        }
        
        String method = paymentMethod.toLowerCase();
        return method.equals("cash") || 
               method.equals("card") || 
               method.equals("credit") ||
               method.equals("debit") ||
               method.equals("online");
    }
}

