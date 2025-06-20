import java.util.HashMap;

public class InventoryManager {
    private HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        if (inventory.containsKey(product.productId)) {
            System.out.println("Product already exists. Use update instead.");
        } else {
            inventory.put(product.productId, product);
            System.out.println("Product added.");
        }
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product p = inventory.get(productId);
        if (p != null) {
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                p.display();
            }
        }
    }
}
