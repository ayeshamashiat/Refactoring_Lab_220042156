package edu.iutcs.cr.utils;

public enum MenuOperation {
    ADD_SELLER(1, "Add new seller"),
    ADD_BUYER(2, "Add new customer"),
    ADD_VEHICLE(3, "Add new vehicle"),
    VIEW_INVENTORY(4, "View inventory"),
    VIEW_SELLERS(5, "View sellers"),
    VIEW_BUYERS(6, "View customers"),
    CREATE_ORDER(7, "Create order"),
    VIEW_INVOICES(8, "View invoices"),
    EXIT(9, "Exit and save");
    
    private final int code;
    private final String description;
    
    MenuOperation(int code, String description) {
        this.code = code;
        this.description = description;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getDescription() {
        return description;
    }
    
    public static MenuOperation fromCode(int code) {
        for (MenuOperation op : values()) {
            if (op.code == code) {
                return op;
            }
        }
        return null;
    }
    
    public static void displayMenu() {
        System.out.println("\n╔" + "═".repeat(50) + "╗");
        System.out.println("║" + " ".repeat(18) + "MAIN MENU" + " ".repeat(23) + "║");
        System.out.println("╠" + "═".repeat(50) + "╣");
        for (MenuOperation op : values()) {
            System.out.printf("║ %-2d. %-44s ║%n", op.code, op.description);
        }
        System.out.println("╚" + "═".repeat(50) + "╝");
    }
}
