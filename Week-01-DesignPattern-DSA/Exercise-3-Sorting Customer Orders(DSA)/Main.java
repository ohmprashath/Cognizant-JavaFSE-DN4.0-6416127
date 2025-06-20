public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 450.75),
            new Order(102, "Bob", 299.99),
            new Order(103, "Charlie", 599.00),
            new Order(104, "David", 199.49)
        };

        System.out.println("Before Sorting:");
        for (Order o : orders) System.out.println(o);

        
        // BubbleSort.bubbleSort(orders);
        QuickSort.quickSort(orders, 0, orders.length - 1);

        System.out.println("\nAfter Sorting by totalPrice:");
        for (Order o : orders) System.out.println(o);
    }
}
