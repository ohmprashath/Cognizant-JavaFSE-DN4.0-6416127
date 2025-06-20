public class Main{
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(101, "Monitor", 10, 6999.99));
        manager.addProduct(new Product(102, "Keyboard", 50, 499.50));
        manager.addProduct(new Product(103, "Mouse", 30, 299.99));

        System.out.println("\nAll Products:");
        manager.displayAllProducts();

        System.out.println("\nUpdating product 102...");
        manager.updateProduct(102, 45, 450.00);

        System.out.println("\nDeleting product 103...");
        manager.deleteProduct(103);

        System.out.println("\nFinal Inventory:");
        manager.displayAllProducts();
    }
}
