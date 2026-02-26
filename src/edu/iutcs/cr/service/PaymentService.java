package edu.iutcs.cr.service;

import edu.iutcs.cr.Invoice;

public class PaymentService {

    public void processPayment(Invoice invoice, boolean paymentDone) {
        if(paymentDone) {
            invoice.markPaid();
        }
    }
}
