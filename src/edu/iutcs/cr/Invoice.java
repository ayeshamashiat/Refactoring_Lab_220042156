import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import java.time.LocalDateTime;

public class Invoice {

    private Buyer buyer;
    private Seller seller;
    private ShoppingCart cart;
    private boolean paid;
    private LocalDateTime createdAt;

    public Invoice(Buyer buyer, Seller seller, ShoppingCart cart) {
        this.buyer = buyer;
        this.seller = seller;
        this.cart = cart;
        this.createdAt = LocalDateTime.now();
        this.paid = false;
    }

    public void markPaid() {
        this.paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // public void takePayment() {
    //     Scanner scanner = new Scanner(System.in);

    //     System.out.print("Is payment done (true/false): ");
    //     this.isPaid = scanner.nextBoolean();
    // }

    // private void markCarAsUnavailable() {
    //     for(Vehicle vehicle: shoppingCart.getVehicles()) {
    //         vehicle.setUnavailable();
    //     }
    // }
}