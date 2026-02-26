package edu.iutcs.cr.service;
import edu.iutcs.cr.Invoice;
/**
 * @author Raian Rahman
 * @since 4/18/2024
 */

public class InvoiceService {

    public void finalizeInvoice(Invoice invoice) {
        if(invoice.isPaid()) {
            System.out.println("Invoice finalized.");
        } else {
            System.out.println("Invoice pending payment.");
        }
    }
}